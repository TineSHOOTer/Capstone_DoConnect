import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatboxComponent } from './chatbox/chatbox.component';
import { NoAuthGuard } from './guards/noAuth/no-auth.guard';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent, canActivate:[NoAuthGuard] },
  { path: 'register', component: SignupComponent  ,canActivate:[NoAuthGuard]},
  { path: 'user', loadChildren: () => import('./user/user.module').then(m => m.UserModule) },
  { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  { path:"",component:LoginComponent},
  {path:'chatbox',component:ChatboxComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
