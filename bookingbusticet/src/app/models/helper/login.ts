export class Login {
    userName: string;
    password: string;
    constructor(userName: string, password: string) {
        this.userName = userName === null ? '' : userName;
        this.password = password === null ? '' : password;
    }
}