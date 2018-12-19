import { Observable, of} from 'rxjs';
import { Staff } from '../models/staff';

export interface StaffSevice {
     findAll(): Observable<Staff[]>;
     findById(id: number): Observable<Staff>;
     delete(id: number): Observable<Staff>;
     save(staff: Staff): Observable<Staff>;
     update(staff: Staff): Observable<any>;
}