import { Component } from '@angular/core';
import { AdminService } from '../services/admin.service';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css'],
})
export class AdminloginComponent {
  email = new FormControl('', [Validators.required, Validators.email]);
  hide = true;

  adminLoginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private adminService: AdminService, private router: Router) {}

  ngOnInit() {}

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'Email field is required';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  adminLogin() {
    this.adminService.getAdminByEmailAndPassword(this.adminLoginForm.value.email, this.adminLoginForm.value.password)
    .subscribe(
      (data) => {
        if(data != null) {
          Swal.fire('Login Successful', '', 'success');
          this.router.navigate(['/home']);
        }
      },
      (error) => {
        Swal.fire('email or password is incorrect', '', 'error');
        console.log(error);
      }
    )
  }
}
