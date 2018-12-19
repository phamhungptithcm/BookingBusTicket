import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/user/home/home.component';
import { TripComponent } from './components/user/trip/trip.component';
import { OrderComponent } from './components/user/order/order.component';
import { ViewallbookedComponent } from './components/user/viewallbooked/viewallbooked.component';
import { CancelbookedComponent } from './components/user/cancelbooked/cancelbooked.component';
import { EditprofileComponent } from './components/user/editprofile/editprofile.component';
import { TripGuard } from './authorization/trip/trip.guard';
import { UserGuard } from './authorization/user/user.guard';
import { OrderGuard } from './authorization/order/order.guard';

// ADMIN
import { UsersComponent } from './components/admin/users/users.component';
import { UserAddComponent } from './components/admin/user-add/user-add.component';
import { UserDetailComponent } from './components/admin/user-detail/user-detail.component';
import { ViewticketsComponent } from './components/staff/viewtickets/viewtickets.component';
import { UpdateticketsComponent } from './components/staff/updatetickets/updatetickets.component';
import { ModifyticketsComponent } from './components/staff/modifytickets/modifytickets.component';
import { TicketsComponent } from './components/staff/tickets/tickets.component';
import { LoginComponent } from './shared/login/login.component';
import { StaffHomeComponent } from './shared/common/home/home.component';
import { AdminGuard } from './authorization/admin/admin.guard';
import { SellerGuard } from './authorization/seller/seller.guard';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'trip/:routeId', component: TripComponent, canActivate: [TripGuard] },
  { path: 'order', component: OrderComponent, canActivate: [OrderGuard, UserGuard] },
  {
    path: 'user', canActivate: [UserGuard], children: [
      { path: 'viewall', component: ViewallbookedComponent, },
      { path: 'canceled', component: CancelbookedComponent },
      { path: 'edit', component: EditprofileComponent }
    ]
  },
  {
    path: 'admin', canActivate: [AdminGuard], children: [
      { path: 'users', component: UsersComponent },
      { path: 'users/add', component: UserAddComponent },
      { path: 'users/:id', component: UserDetailComponent },
    ]
  },

  { path: 'staff/viewtickets', component: ViewticketsComponent },
  { path: "staff/updatetickets", component: UpdateticketsComponent },
  { path: "staff/updatetickets/abc/:id", component: ModifyticketsComponent },
  { path: "staff/tickets", component: TicketsComponent },
  { path: "staff", component: StaffHomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }