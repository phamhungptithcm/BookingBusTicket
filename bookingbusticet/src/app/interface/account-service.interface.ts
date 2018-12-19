import { Observable, of} from 'rxjs';
import { Account } from '../models/account';

export interface AccountSevice {
     findAll(): Observable<Account[]>;
     findById(username: String): Observable<Account>;
     delete(username: String): Observable<Account>;
     save(account: Account): Observable<Account>;
     update(account: Account): Observable<any>;
}