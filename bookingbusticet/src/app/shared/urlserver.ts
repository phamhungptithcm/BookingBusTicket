export class URLServer {
    domain = 'http://localhost:8080';
    userUrlFU = this.domain + '/user/manage';
    tripUrlFU = this.domain + '/user/trip';
    ticketUrlFU = this.domain + '/user/ticket';
    routeUrlFU = this.domain + '/user/route';
    provinceUrlFU = this.domain+'/user/province';
    orderUrlFU = this.domain + '/user/order';
    busUrlFU = this.domain + '/user/bus';
    oauthTokenUrl = this.domain + '/oauth/token';

    /// Get token
    tokenUrl = 'access_token=' + localStorage.getItem("access_token");

    //ADMIN
    usersUrlFA =this.domain+ '/admin/users';

    //STAFF
    ticketDetailsUrlFS = this.domain + '/staff/booked';
}