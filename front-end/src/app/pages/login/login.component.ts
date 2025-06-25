import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  protected loginForm: FormGroup;
  protected isLoading = false;
  protected errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  protected onSubmit() {
    if (this.loginForm.valid) {
      this.isLoading = true;
      this.errorMessage = '';

      // Simulation appel API
      setTimeout(() => {
        this.isLoading = false;
        const { email, password } = this.loginForm.value;

        if (email === 'admin@sonatel.sn' && password === 'sonatel123') {
          this.router.navigate(['/dashboard']);
        } else {
          this.errorMessage = 'Email ou mot de passe incorrect';
        }
      }, 1500);
    }
  }
}
