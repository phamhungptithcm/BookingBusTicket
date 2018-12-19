import { Observable, of} from 'rxjs';
import { OrderDetail } from '../models/orderdetail';

export interface OrderDetailSevice {
     findAll(): Observable<OrderDetail[]>;
     findById(id: number): Observable<OrderDetail>;
     delete(id: number): Observable<OrderDetail>;
     save(orderDetail: OrderDetail): Observable<OrderDetail>;
     update(orderDetail: OrderDetail): Observable<any>;
}