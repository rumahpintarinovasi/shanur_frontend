interface Invoice {
    id? : string
    invoiceDate?: string,
    invoiceNumber?: string,
    trxTableName?: string,
    price?: number,
    totalItem?: number,
    type? : string,
    invoiceItems? : InvoiceItem[]
    status? : string
}

interface InvoiceItem {
    id ?: string
    productId : string,
    quantity: number,
    price : number,
    productName? : string
}

interface NewInvoice {
    invoiceDate : string,
    invoiceItems? : InvoiceItem[]
}

interface Product { 
    id : string,
    name : string,
    initPrice : number,
    sellingPrice: number,
    unit : string,
    margin : number,
    quantity : number,
}

interface NewProduct {
    name : string,
    initPrice : number,
    sellingPrice: number,
    unit : string,
}

interface Stock {
    id : string,
    productId : string,
    quantity : number,
    price : number
}

interface NewStock {
    productId : string,
    quantity : number,
    price : number
}

interface InputFileEvent extends Event {
    target : HTMLInputElement
}

interface RequestPayload {
    whereConditions? : string[] | string
    page? : number
    size? : number
}

interface Discount {
    discountPercentage : number
    level : number
    productId : string
}

interface NewDiscount {
    discountPercentage : number
    level : number
    ProductId : string
}

interface User {
    id ? : string
    name : string
    role ? : string
    storeName ?: string
    status: string
    roleId? : string
    storeId ? : string
    password ? : string
    email ? : string,
    createdAt? : String,
    deleteAt? : String | null
    updatedAt? : String | null
    userName ?: String
}

interface Store {
    id ? : String
    name : String
    type : String
    createdAt? : String,
    deleteAt? : String | null
    updatedAt? : String | null
}


interface Error {
    err : true,
    error : any
}

interface Role {
    id ? : string
    name : string
    createdAt? : String,
    deleteAt? : String | null
    updatedAt? : String | null
}

interface Customer {
    id ? : string
    name : string
    level : string
    phoneNumber : string,
    createdAt? : String,
    deleteAt? : String | null
    updatedAt? : String | null
}
export type { Invoice, NewInvoice, InvoiceItem, Product, NewProduct, Stock, NewStock, InputFileEvent, RequestPayload, Discount, NewDiscount, User, Store, Error, Role, Customer }