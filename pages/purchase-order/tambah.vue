<template>
  <div>
    <NuxtLayout>
      <div class="wrapper">
        <div class="main-content">
          <div class="row small-spacing">
            <div class="">
              <div
                class="box-content"
                style="display: flex; flex-direction: column; gap: 30px"
              >
                <div style="display: flex; gap: 30px">
                  <h4 style="min-width: 100px">Tanggal</h4>
                  <div class="input-group" style="width: 100%">
                    <input
                      @change="(e) => handleChangeInvoiceForm(e)"

                      :value="invoiceForm.invoiceDate"
                      type="date"
                      name="invoiceDate"
                      class="form-control"
                      placeholder="mm/dd/yyyy"
                      id="datepicker"
                      style="width: 100%"
                    />
                  </div>
                </div>

                <div style="display: flex; gap: 30px">
                  <h4 style="min-width: 100px">Type</h4>
                  <div class="input-group" style="width: 100%">
                    <select
                      name="type"
                      class="form-select form-control"
                      :value="invoiceForm?.type"
                    >
                      <option selected :value="''">
                        Select Purchase Order Type
                      </option>
                      <option value="Purchase Order">Purchase Order</option>
                      <option value="Return">Return</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row small-spacing">
            <div class="col-lg-12 col-xs-12">
              <div class="box-content">
                <table
                  class="table table-striped margin-bottom-10 margin-top-10"
                  style="margin-bottom: 20px"
                >
                  <thead>
                    <tr>
                      <th style="width: 20%">Item</th>
                      <th>Price</th>
                      <th>Quantity</th>
                      <th>Total</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr
                      v-for="(item, index) in invoiceForm.invoiceItems"
                      :key="index"
                    >
                      <td v-if="editedRow !== index" >
                        {{ item.productName }}
                      </td>
                      <td v-else >
                        <Dropdown
                          :options="products"
                          optionLabel="name"
                          optionValue="id"
                          style="padding: 10px 0; width: 100%;"
                          placeholder="Choose a product"
                          filter
                          showClear
                          :filterPlaceholder="'Search'"
                          :modelValue="item.productId"
                          @change="(e) => handleChangeEditedProductItem(e, index)"
                        />
                      </td>

                      <td v-if="editedRow !== index">
                        {{ formatCurrency(item.price) }}
                      </td>

                      <td v-else >
                        <input
                          class="form-control"
                          placeholder="Harga"
                          :value="item.price"
                          disabled
                        />
                      </td>


                      <td v-if="editedRow !== index" >
                        {{ item.quantity }}
                      </td>

                      <td v-else >
                        <input
                          class="form-control"
                          placeholder="Jumlah"
                          type="number"
                          min="1"
                          :value="item.quantity"
                          @change="(e) => handleChangeEditedQuantityItem(e, index)"
                        />
                      </td>

                      <td v-if="editedRow !== index" >
                        {{ formatCurrency(item.quantity * item.price) }}
                      </td>

                      <td v-else >
                        <input
                          class="form-control"
                          placeholder="Total"
                          disabled
                          :value="item.quantity * item.price"
                        />
                      </td>

                      <td v-if="index !== editedRow" style="display: flex; gap: 10px">
                        <button @click="() => handleOpenEditRow(item, index)" class="btn btn-info fa fa-pencil" />
                        <button  class="btn btn-danger fa fa-trash" />
                      </td>

                      <td v-else style="display: flex; gap: 10px" >
                        <button @click="() => { editedRow = null }" class="btn btn-primary fa fa-save"></button>
                        <button @click="() => handleCancelEdit(index)" class="btn btn-warning fa fa-close"></button>
                      </td>
                    </tr>


                    <tr v-if="isAddNewItem">
                      <td>
                        <Dropdown
                          :options="products"
                          v-model="selectedProduct"
                          optionLabel="name"
                          @change="(e) => handleChangeProductItem(e)"
                          style="padding: 10px 0; width: 100%;"
                          placeholder="Choose a product"
                          filter
                          showClear
                          :filterPlaceholder="'Search'"
                        />
                      </td>
                      <td>
                        <input
                          class="form-control"
                          placeholder="Harga"
                          :value="newInvoiceItem.price"
                          disabled
                        />
                      </td>
                      <td>
                        <input
                          class="form-control"
                          placeholder="Jumlah"
                          type="number"
                          min="1"
                          :value="newInvoiceItem.quantity"
                          @click="(e) => handleChangeQuantity(e)"
                        />
                      </td>
                      <td>
                        <input
                          class="form-control"
                          placeholder="Total"
                          disabled
                          :value="newInvoiceItem.total"
                        />
                      </td>

                      <td class="gap-2" style="display: flex; gap: 10px">
                        <button @click="handleSaveInvoiceItems" class="btn btn-primary fa fa-save"></button>
                        <button @click="() => (isAddNewItem = false)" class="btn btn-warning fa fa-close"></button>
                      </td>
                    </tr>
                  </tbody>

                  <button style="margin-top: 20px;" @click="() => (isAddNewItem = true)" class="btn">
                    Add Item
                  </button>
                </table>
              </div>
            </div>
          </div>

          <div class="row small-spacing">
            <div class="col-lg-6 col-xs-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Total</h4>
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control font-bold"
                      placeholder="Rp. 0"
                      :value="formatCurrency(totalPrice)"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-xs-12">
              <div class="flex-custom-responsive">
                <button @click="handleSaveInvoices" class="btn btn-success">Save Invoices</button>

                <button @click="$router.push('/purchase-order')" class="btn btn-danger">Cancel</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </NuxtLayout>
  </div>
</template>

<script lang="ts" setup>
definePageMeta({
  layout: "dashboard",
});
import { useProductStore, useInvoicesStore } from "~/store";
import type {
  NewInvoice,
  Product,
  InputFileEvent,
  InvoiceItem,
  Invoice,
} from "../../helpers/interface";
import { formatCurrency } from "~/helpers";
import Swal from "sweetalert2";
import Tooltip from 'primevue/tooltip'
import type { DropdownChangeEvent } from "primevue/dropdown";

interface NewInvoiceItem extends InvoiceItem {
  total: number;
}
const handleChangeInvoiceForm = (e: Event) => {
  const el = e as InputFileEvent;
  const { value, name } = el.target;

  switch (name) {
    case 'type':
    case "invoiceDate":
      invoiceForm.value[name] = value;
      break;

    default:
      break;
  }
};
const $router = useRouter()
const { fetchProduct } = useProductStore();
const { addInvoices } = useInvoicesStore();
const selectedProduct = ref<any>(null);
const products = ref<Product[]>();
const invoiceForm = ref<NewInvoice>({
  invoiceDate: "",
  invoiceItems: [],
  type: "",
});
const editedRow = ref<number|null>(null)
const newInvoiceItem = ref<NewInvoiceItem>({
  productId: "",
  quantity: 0,
  price: 0,
  total: 0,
});
const isAddNewItem = ref<boolean>(false);
const defaultEditedValue = ref<NewInvoiceItem>({
  productId: "",
    quantity: 0,
    price: 0,
    total: 0,
})

const totalPrice = computed(() => {
  let total = 0;
  invoiceForm.value.invoiceItems?.forEach((item) => {
    total += Number(item.price) * Number(item.quantity);
  });
  return total;
});

const handleOpenEditRow = (item: any, index:number) => {
  editedRow.value = index
  const tempDefaultValue = {...item}
  defaultEditedValue.value = tempDefaultValue
}
const handleFetchProductOptions = async (options : any) => {
  const fetchProductValue = await fetchProduct()
  products.value = fetchProductValue
}

const handleChangeQuantity = (value: Event) => {
  const el = value as InputFileEvent;
  newInvoiceItem.value.quantity = Number(el.target.value);
  newInvoiceItem.value.total =
    newInvoiceItem.value.price * newInvoiceItem.value.quantity;
};
const handleSaveInvoiceItems = () => {
  const newItem: InvoiceItem = {
    productId: newInvoiceItem.value.productId,
    quantity: newInvoiceItem.value.quantity,
    price: newInvoiceItem.value.price,
    productName: newInvoiceItem.value.productName,
  };

  invoiceForm.value.invoiceItems?.push(newItem);
  newInvoiceItem.value = {
    productId: "",
    quantity: 0,
    price: 0,
    total: 0,
  };
  selectedProduct.value = null
};

const handleChangeProductItem = (value: DropdownChangeEvent) => {
  const el = value.value
  const productId: string = el.id;
  const index: number = products.value?.findIndex((item) => item.id === productId) || 0;
  const productName: string = el.name;
  newInvoiceItem.value.productId = productId;
  newInvoiceItem.value.price = products.value
    ? products.value[index].sellingPrice
    : 0;
  newInvoiceItem.value.productName = productName;

  el.value = null
};

const handleChangeEditedProductItem = (event : DropdownChangeEvent, index : number) => {
  const { value } = event
  const product = products.value?.find((item:any) => item.id === value)
  if (invoiceForm && invoiceForm.value && invoiceForm.value.invoiceItems) {
    const tempEditedObject = invoiceForm.value.invoiceItems[index]
    tempEditedObject.price = product?.sellingPrice || 0
  }

}

const handleChangeEditedQuantityItem = (event : Event, index: number) => {
  const el = event as InputFileEvent;
  const { value } = el.target
  if (invoiceForm && invoiceForm.value && invoiceForm.value.invoiceItems) {
    const tempEditedObject = invoiceForm.value.invoiceItems[index]
    tempEditedObject.quantity = Number(value) || 0
  }
}

const handleCancelEdit = (index:number) => {
  if (invoiceForm.value && invoiceForm.value.invoiceItems) {
    invoiceForm.value.invoiceItems[index] = defaultEditedValue.value
  }

  editedRow.value = null
}

const handleSaveInvoices = async () => {
  try {
    invoiceForm.value.invoiceItems?.forEach((item) => {
    delete item.productName;
  });

  const newInvoices = {
    type: invoiceForm.value.type,
    invoiceDate: invoiceForm.value.invoiceDate,
    invoiceItems: invoiceForm.value.invoiceItems,
    storeId : localStorage.getItem('storeId'),
    slug : 'PO'
  };

  await addInvoices(newInvoices);
  $router.push('/purchase-order')
  } catch (error) {
    
  }

};
onMounted(async () => {
  await handleFetchProductOptions({})
});

// Method
const handleSave = async (payload: Invoice) => {
  payload.status = "Requested";

  delete payload.price;
  delete payload.totalItem;

  payload.invoiceItems?.forEach((item) => {
    delete item.productName;
  });

  await addInvoices(payload);

  Swal.fire({
    icon: "success",
    text: "Success Create New Purchase Order",
  });
};

//
</script>
