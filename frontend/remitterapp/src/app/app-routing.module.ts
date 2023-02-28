import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { FundtransderComponent } from './fundtransder/fundtransder.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: "", component: AdminloginComponent },
  { path: "home", component: HomeComponent },
  { path: "fundtransfer",component: FundtransderComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
