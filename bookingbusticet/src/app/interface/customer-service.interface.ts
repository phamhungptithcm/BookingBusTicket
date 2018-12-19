import { Observable, of} from 'rxjs';
import { Customer } from '../models/customer';

export interface CustomerSevice {
     findAll(): Observable<Customer[]>;
     findById(id: number): Observable<Customer>;
     delete(id: number): Observable<Customer>;
     save(customer: Customer): Observable<Customer>;
     update(customer: Customer): Observable<any>;
}