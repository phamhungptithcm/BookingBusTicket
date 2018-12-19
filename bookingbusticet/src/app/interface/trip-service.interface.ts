import { Observable, of} from 'rxjs';
import { Trip } from '../models/trip';

export interface TripSevice {
     findAll(): Observable<Trip[]>;
     findById(id: number): Observable<Trip>;
     delete(id: number): Observable<Trip>;
     save(trip: Trip): Observable<Trip>;
     update(trip: Trip): Observable<any>;
     findByRouteId(from: number, to: number): Observable<Trip[]>;
}