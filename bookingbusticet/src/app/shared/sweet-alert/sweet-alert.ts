import swal, { SweetAlertType } from 'sweetalert2';

export class SweetAlert {
    showMessageToast(stt: SweetAlertType, value: string): void {
        const toast = swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000
        });
        toast({
            type: stt,
            title: value
        });
    }
    showMessageToastCenter(stt: SweetAlertType, value: string): void {
        const toast = swal.mixin({
            toast: true,
            position: 'top-start',
            showConfirmButton: false,
            timer: 3000
        });
        toast({
            type: stt,
            title: value
        });
    }
    showMessageSwal(stt: SweetAlertType, value: string): void {
        swal(
            value,
            'You clicked the button!',
            stt
        );
    }
    showMessageSwalCenter(stt: SweetAlertType, value: string) {
        swal({
            position: 'center',
            type: stt,
            title: value,
            showConfirmButton: false,
            timer: 3500
        })
    }
}