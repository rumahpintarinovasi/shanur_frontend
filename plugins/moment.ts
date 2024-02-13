import moment from 'moment'

export default defineNuxtPlugin(() => {
    return {
        provide: {
            moment: (d:string) => moment(d) 
        }
    }
})