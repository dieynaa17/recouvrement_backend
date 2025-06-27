package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Indicateur;
import com.sonatel.recouvrement.repository.IndicateurRepository;
import com.sonatel.recouvrement.repository.FactureRepository;
import com.sonatel.recouvrement.repository.PaiementRepository;
import com.sonatel.recouvrement.service.IndicateurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicateurServiceImpl implements IndicateurService {

    private final IndicateurRepository indicateurRepository;
    private final FactureRepository factureRepository;
    private final PaiementRepository paiementRepository;

    public IndicateurServiceImpl(IndicateurRepository indicateurRepository,
                                 FactureRepository factureRepository,
                                 PaiementRepository paiementRepository) {
        this.indicateurRepository = indicateurRepository;
        this.factureRepository = factureRepository;
        this.paiementRepository = paiementRepository;
    }

    @Override
    public List<Indicateur> findAll() {
        return indicateurRepository.findAll();
    }

    @Override
    public Indicateur findById(Long id) {
        return indicateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Indicateur introuvable avec l'id: " + id));
    }

    @Override
    public Indicateur save(Indicateur indicateur) {
        return indicateurRepository.save(indicateur);
    }

    @Override
    public void deleteById(Long id) {
        findById(id); // vérifie existence
        indicateurRepository.deleteById(id);
    }

    // ✅ Calcul du chiffre d'affaires
    @Override
    public Indicateur calculerChiffreAffaires(String segment, String marche, String offre, String periode) {
        Double total = factureRepository.getTotalFacturesByFiltre(segment, marche, offre, periode);
        if (total == null) total = 0.0;

        Indicateur indicateur = new Indicateur(
                "chiffreAffaires", total, periode, segment, marche, offre
        );
        return indicateurRepository.save(indicateur);
    }

    // ✅ Calcul du taux de recouvrement
    @Override
    public Indicateur calculerTauxRecouvrement(String segment, String marche, String offre, String periode) {
        Double totalFactures = factureRepository.getTotalFacturesByFiltre(segment, marche, offre, periode);
        Double totalPaiements = paiementRepository.getTotalPaiementsByFiltre(segment, marche, offre, periode);

        if (totalFactures == null || totalFactures == 0.0) return null;
        if (totalPaiements == null) totalPaiements = 0.0;

        double taux = (totalPaiements / totalFactures) * 100;

        Indicateur indicateur = new Indicateur(
                "tauxRecouvrement", taux, periode, segment, marche, offre
        );
        return indicateurRepository.save(indicateur);
    }
}

