import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Chart, registerables } from 'chart.js';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  ngOnInit(): void {
    this.initChart();
  }

  initChart(): void {
    Chart.register(...registerables);

    const ctx = document.getElementById('recoveryChart') as HTMLCanvasElement;
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Jun', 'Jul'],
        datasets: [
          {
            label: '30 Jours',
            data: [85, 86, 87, 89, 90, 91, 92],
            borderColor: '#27ae60',
            backgroundColor: 'rgba(39, 174, 96, 0.1)',
            tension: 0.3
          },
          {
            label: '45 Jours',
            data: [75, 76, 77, 76, 77, 78, 78],
            borderColor: '#f39c12',
            backgroundColor: 'rgba(243, 156, 18, 0.1)',
            tension: 0.3
          },
          {
            label: '60 Jours',
            data: [60, 62, 63, 63, 64, 64, 65],
            borderColor: '#e74c3c',
            backgroundColor: 'rgba(231, 76, 60, 0.1)',
            tension: 0.3
          }
        ]
      },
      options: {
        responsive: true,
        plugins: {
          title: {
            display: true,
            text: 'Taux de Recouvrement par Période'
          },
        },
        scales: {
          y: {
            beginAtZero: false,
            min: 50,
            max: 100,
            ticks: {
              callback: function(value) {
                return value + '%';
              }
            }
          }
        }
      }
    });
  }
}
