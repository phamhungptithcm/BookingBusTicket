import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServiceModule } from './service/service.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './shared/header/header.component';
import { LoginComponent } from './shared/login/login.component';
import { SignupComponent } from './shared/signup/signup.component';

import { CommonModule } from '@angular/common';
import { ProvinceComponent } from './components/user/province/province.component';
import { HomeComponent } from './components/user/home/home.component';
import { FooterComponent } from './shared/footer/footer.component';
import { SearchingComponent } from './shared/searching/searching.component';
import { TripComponent } from './components/user/trip/trip.component';
// Admin component

import { SeatComponent } from './components/user/seat/seat.component';

import { DragDropModule } from '@angular/cdk/drag-drop';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { CdkTableModule } from '@angular/cdk/table';
import { CdkTreeModule } from '@angular/cdk/tree';
import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
  MatFormFieldModule,
  MatLineModule,
  MatOptionModule,
  MatRadioGroup,
  MAT_DATE_LOCALE
} from '@angular/material';
import { OrderComponent } from './components/user/order/order.component';
// import {
//   SocialLoginModule,
//   AuthServiceConfig,
//   GoogleLoginProvider,
//   FacebookLoginProvider,
// } from 'angular5-social-login';
import { ValidatorsModule } from 'ng2-validators';
import { SweetAlert2Module } from '@toverux/ngx-sweetalert2';
import { EditprofileComponent } from './components/user/editprofile/editprofile.component';
import { ViewallbookedComponent } from './components/user/viewallbooked/viewallbooked.component';
import { CancelbookedComponent } from './components/user/cancelbooked/cancelbooked.component';
import { InfoticketComponent } from './components/user/infoticket/infoticket.component';
import { TripGuard } from './authorization/trip/trip.guard';
import { UserGuard } from './authorization/user/user.guard';
import { OrderGuard } from './authorization/order/order.guard';
import { UserAddComponent } from './components/admin/user-add/user-add.component';
import { UserDetailComponent, ChangePasswordDialog } from './components/admin/user-detail/user-detail.component';
import { UsersComponent } from './components/admin/users/users.component';
import { CheckPasswordDirective } from './components/admin/validator/check-password.directive';
import { NgxPaginationModule } from 'ngx-pagination';
import { UpdateseatComponent } from './components/staff/updateseat/updateseat.component';
import { UpdateticketdetailComponent } from './components/staff/updateticketdetail/updateticketdetail.component';
import { TicketsComponent } from './components/staff/tickets/tickets.component';
import { ModifyticketsComponent } from './components/staff/modifytickets/modifytickets.component';
import { UpdateticketsComponent } from './components/staff/updatetickets/updatetickets.component';
import { ViewticketsComponent } from './components/staff/viewtickets/viewtickets.component';
import { StaffHomeComponent } from './shared/common/home/home.component';
import { AdminGuard } from './authorization/admin/admin.guard';
import { CookieService } from 'ngx-cookie-service';
import { ForgotComponent } from './shared/forgot/forgot/forgot.component';
import { NgProgressModule } from 'ngx-progressbar';
import { TranslocoRootModule } from './transloco/transloco-root.module';
// Configs
// export function getAuthServiceConfigs() {
//   let config = new AuthServiceConfig(
//     [
//       {
//         id: FacebookLoginProvider.PROVIDER_ID,
//         // 561602290896109
//         provider: new FacebookLoginProvider('')
//       },
//       {
//         id: GoogleLoginProvider.PROVIDER_ID,
//         provider: new GoogleLoginProvider('624796833023-clhjgupm0pu6vgga7k5i5bsfp6qp6egh.apps.googleusercontent.com')
//       },
//     ]
//   );
//   return config;
// }
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    SignupComponent,
    ProvinceComponent,
    HomeComponent,
    FooterComponent,
    SearchingComponent,
    TripComponent,
    SeatComponent,
    OrderComponent,
    EditprofileComponent,
    ViewallbookedComponent,
    CancelbookedComponent,
    InfoticketComponent,
    UserAddComponent,
    UserDetailComponent,
    UsersComponent,
    ChangePasswordDialog,
    ViewticketsComponent,
    UpdateticketsComponent,
    ModifyticketsComponent,
    TicketsComponent,
    HeaderComponent,
    UpdateticketdetailComponent,
    UpdateseatComponent,
    StaffHomeComponent,
    CheckPasswordDirective,
    ForgotComponent
  ],
  imports: [
    ReactiveFormsModule,
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ServiceModule,
    BrowserAnimationsModule,
    BrowserModule,
    MatFormFieldModule,
    MatLineModule,
    MatOptionModule,
    CdkTableModule,
    CdkTreeModule,
    DragDropModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    ScrollingModule,
    MatRadioModule,
    ValidatorsModule,
    SweetAlert2Module.forRoot(),
    MatNativeDateModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    NgProgressModule,
    TranslocoRootModule 
  ],
  providers: [
    // {
    //   provide: AuthServiceConfig,
    //   useFactory: getAuthServiceConfigs,
    // },
    { provide: MAT_DATE_LOCALE, useValue: 'en-GB' },
    TripGuard,
    UserGuard,
    OrderGuard,
    AdminGuard,
    CookieService
  ],
  entryComponents: [UserDetailComponent, ChangePasswordDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
