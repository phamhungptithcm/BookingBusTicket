import {Account} from './account';

export class Customer {
	customerId: number;
	lastName: String;
	firstName: String;
	phoneNum: String;
	email: String;
	gender: boolean;
    lastUpdate: String;
    account: Account;
}