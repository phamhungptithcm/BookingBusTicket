import { Observable, of} from 'rxjs';
import { Order } from '../models/order';

export interface OrderSevice {
     findAll(): Observable<Order[]>;
     findById(id: number): Observable<Order>;
     delete(id: number): Observable<Order>;
     save(order: Order): Observable<Order>;
     update(order: Order): Observable<any>;
}