<template>
  <div id="wrapper">
    <div class="main-content">
      <!-- /.row small-spacing two -->
      <div class="row small-spacing">
        <div class="">
          <div class="box-content custom-height">
            <div v-if="action === 'detail'" class="">
              <h4 class="box-title">Invoice Number</h4>
              <div class="input-group" style="width: 100%">
                <input
                  v-if="!isEdit"
                  :value="invoiceForm?.invoiceNumber"
                  class="form-control"
                  disabled
                />
                <input
                  v-else
                  @change="(e) => handleChangeInvoiceForm(e)"
                  :value="new Date(invoiceForm?.invoiceDate || '')"
                  type="date"
                  name="invoiceDate"
                  class="form-control"
                  placeholder="mm/dd/yyyy"
                  id="datepicker"
                  style="width: 100%"
                />
              </div>
            </div>

            <div class="flex-custom middle" style="margin-top: 20px">
              <h4 class="box-title">Type</h4>

              <div class="input-group" style="width: 100%">
                <select 
                  name="type"
                  class="form-select form-control" 
                  @change="handleChangeInvoiceForm"
                >
                    <option selected disabled>Select Purchase Order Type</option>
                    <option value="Purchase Order" >Purchase Order</option>
                    <option value="Return" >Return</option>
                </select>
              </div>
            </div>

            <div class="flex-custom middle" style="margin-top: 20px">
              <h4 class="box-title">Invoice Date</h4>
              <div class="input-group" style="width: 100%">
                <input
                  v-if="!isEdit"
                  :value="
                    $moment(invoiceForm?.invoiceDate).format('YYYY MMMM DD')
                  "
                  class="form-control"
                  disabled
                />
                <input
                  v-else
                  @change="(e) => handleChangeInvoiceForm(e)"
                  :value="new Date(invoiceForm?.invoiceDate || '')"
                  type="date"
                  name="invoiceDate"
                  class="form-control"
                  placeholder="mm/dd/yyyy"
                  id="datepicker"
                  style="width: 100%"
                />
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="row small-spacing">
        <!-- Kartu Stok -->
        <div class="col-lg-12 col-xs-12">
          <div class="box-content">
            <table class="table table-striped margin-bottom-10 margin-top-10">
              <thead>
                <tr>
                  <th style="width: 20%">Item</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Total</th>
                  <th v-if="isEdit">Action</th>
                </tr>
              </thead>
              <tbody>
                <tr
                  v-for="(item, index) in invoiceForm?.invoiceItems"
                  :key="index"
                >
                  <td>
                    {{ item.productName }}
                  </td>
                  <td>
                    {{ formatCurrency(item.price) }}
                  </td>
                  <td>
                    {{ item.quantity }}
                  </td>
                  <td>
                    {{ formatCurrency(item.quantity * item.price) }}
                  </td>
                  <td v-if="isEdit" style="display: flex; gap: 10px">
                    <button class="btn btn-info fa fa-pencil" />
                    <button @click="() => {
                      invoiceForm?.invoiceItems?.splice(index, 1)
                    }" class="btn btn-danger fa fa-trash" />
                  </td>
                </tr>

                <tr v-if="isAddNewItem">
                  <td>
                    <!-- <input class="form-control" placeholder="Nama Item"  /> -->
                    <select
                      @change="(e) => handleChangeProductItem(e)"
                      class="form-select form-control"
                      placeholder="Item"
                    >
                      <option selected disabled>Open this select menu</option>
                      <option
                        v-for="(product, index) in products"
                        :value="`${product.id}|${index}|${product.name}`"
                        :key="index"
                      >
                        {{ product.name }}
                      </option>
                    </select>
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
                      @change="(e) => handleChangeQantity(e)"
                      class="form-control"
                      placeholder="Jumlah"
                      type="number"
                      min="0"
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
                    <button
                      @click="handleSaveInvoiceItems"
                      class="btn btn-primary fa fa-save"
                    ></button>
                    <button
                      @click="() => (isAddNewItem = false)"
                      class="btn btn-warning fa fa-close"
                    ></button>
                  </td>
                </tr>
              </tbody>
            </table>

            <button
              v-if="isEdit"
              @click="() => (isAddNewItem = true)"
              class="btn"
            >
              Add Item
            </button>
          </div>
          <!-- /.box-content -->
        </div>
      </div>

      <div class="row small-spacing">
        <!-- Kartu Stok -->
        <div class="col-lg-6 col-xs-12">
          <div class="box-content">
            <div class="flex-custom">
              <h4 class="box-title">Total</h4>
              <div class="form-group" style="max-width: 100%">
                <input
                  type="text"
                  disabled
                  class="form-control font-bold"
                  placeholder="Rp. 0"
                  style="max-width: 100%"
                  :value="formatCurrency(totalPrice)"
                />
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6 col-xs-12">
          <!-- button ajukan po (green) batalkan po (red) flex row but in mobile column-->
          <div class="flex-custom-responsive">
            <button
              v-if="isEdit"
              @click="emits('handleSave', invoiceForm)"
              type="button"
              class="btn btn-success"
            >
              Save
            </button>
            <button
              @click="() => $router.back()"
              type="button"
              class="btn btn-danger"
            >
              Back
            </button>
          </div>
        </div>
      </div>

      <Footer />
    </div>
  </div>
</template>

<script lang="ts" setup>
import type {
  InvoiceItem,
  Product,
  NewInvoice,
  InputFileEvent,
  Invoice,
} from "~/helpers/interface";
import { formatCurrency } from "~/helpers/utils";
import moment from "~~/plugins/moment";
const router = useRouter();
const $moment = moment().provide.moment;
interface NewInvoiceItem extends InvoiceItem {
  total: number;
}

interface InvoiceFormProps {
  product?: Product[] | [];
  invoiceForm?: Invoice;
  type: string;
  action: string;
}

const props = defineProps<InvoiceFormProps>();
const emits = defineEmits<{
  (e: 'handleSave', payload: Invoice) : void
}>()

// Ref State
const products = toRef(props, "product");
const invoiceForm = toRef(props, "invoiceForm");
const type = toRef(props, "type");
const action = toRef(props, "action");
const newInvoiceItem = ref<NewInvoiceItem>({
  productId: "",
  quantity: 0,
  price: 0,
  total: 0,
});
const isEdit = action.value === "edit";
const isAddNewItem = ref<boolean>(false);

const totalPrice = computed(() => {
  let total = 0;
  invoiceForm?.value?.invoiceItems?.forEach((item) => {
    total += Number(item.price) * Number(item.quantity);
  });
  return total;
});

// Method
const handleChangeProductItem = (value: Event) => {
  const el = value as InputFileEvent;
  const rawValue: string = el.target.value;
  const rawValueArr: string[] = rawValue.split("|");
  const productId: string = rawValueArr[0];
  const index: number = Number(rawValueArr[1]);
  const productName: string = rawValueArr[2];

  newInvoiceItem.value.productId = productId;
  newInvoiceItem.value.price = products.value
    ? products.value[index].sellingPrice
    : 0;
  newInvoiceItem.value.productName = productName;

};

const handleChangeQantity = (value: Event) => {
  const el = value as InputFileEvent;
  newInvoiceItem.value.quantity = Number(el.target.value);
  newInvoiceItem.value.total =
    newInvoiceItem.value.price * newInvoiceItem.value.quantity;
};

const handleChangeInvoiceForm = (e: Event) => {
  const el = e as InputFileEvent;
  const { value, name } = el.target;

  switch (name) {
    case "invoiceDate":
    case "type":
      if (invoiceForm.value) {
        invoiceForm.value[name] = value;
      }
      break;

    default:
      break;
  }

};

const handleSaveInvoiceItems = () => {
  const newItem: InvoiceItem = {
    productId: newInvoiceItem.value.productId,
    quantity: newInvoiceItem.value.quantity,
    price: newInvoiceItem.value.price,
    productName: newInvoiceItem.value.productName,
  };

  invoiceForm?.value?.invoiceItems?.push(newItem);
  newInvoiceItem.value = {
    productId: "",
    quantity: 0,
    price: 0,
    total: 0,
  };
};

// const handleSave = async () => {
//   invoiceForm?.value?.invoiceItems?.forEach((item) => {
//     delete item.productName;
//   });

//   const newInvoices = {
//     type: "Cashier",
//     status: "Accepted",
//     invoiceDate: invoiceForm?.value?.invoiceDate,
//     invoiceItems: invoiceForm?.value?.invoiceItems,
//   };
// };
</script>

<style global></style>
