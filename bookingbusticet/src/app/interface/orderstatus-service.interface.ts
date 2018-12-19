import { Observable, of} from 'rxjs';
import { OrderStatus } from '../models/orderstatus';

export interface OrderStatusSevice {
     findAll(): Observable<OrderStatus[]>;
     findById(id: number): Observable<OrderStatus>;
     delete(id: number): Observable<OrderStatus>;
     save(orderStatus: OrderStatus): Observable<OrderStatus>;
     update(orderStatus: OrderStatus): Observable<any>;
}