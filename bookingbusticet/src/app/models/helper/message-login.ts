export class MessageLogin{
    token: string;
    url: string;

    constructor(token: string, url: string){
        this.token = token;
        this.url = url;
    }
}