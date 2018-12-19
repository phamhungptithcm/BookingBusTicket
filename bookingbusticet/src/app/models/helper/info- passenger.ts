export class Passenger {
    lastName: string;
    firstName: string;
    age: number;
    gender: boolean;
    constructor(firstName, lastName, gender, age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }
}