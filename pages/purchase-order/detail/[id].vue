<template>
  <div>
    <NuxtLayout>
      <div class="wrapper">
        <div class="main-content">
          <div class="row small-spacing">
            <div class="">
              <div class="">
                <div
                  class="box-content"
                  style="display: flex; flex-direction: column; gap: 30px"
                >
                  <div style="display: flex; gap: 30px">
                    <h4 style="min-width: 100px">No Invoices</h4>
                    <div class="input-group" style="width: 100%">
                      <input
                        :value="invoiceDetail.invoiceNumber"
                        disabled
                        class="form-select form-control"
                      />
                    </div>
                  </div>
                  <div style="display: flex; gap: 30px">
                    <h4 style="min-width: 100px">Tanggal</h4>
                    <div class="input-group" style="width: 100%">
                      <input
                        type="date"
                        :value="
                          $moment(invoiceDetail.invoiceDate).format(
                            'YYYY-MM-DD'
                          )
                        "
                        disabled
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
                        disabled
                        :value="invoiceDetail.type"
                        name="type"
                        class="form-select form-control"
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
                      <th v-if="isEditPage">Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr
                      v-for="(item, index) in invoiceDetail.invoiceItems"
                      :key="index"
                    >
                      <td v-if="editedRow !== index">
                        {{ item.productName }}
                      </td>

                      <td v-else>
                        <Dropdown
                          :options="products"
                          optionLabel="name"
                          optionValue="id"
                          style="padding: 10px 0; width: 100%"
                          placeholder="Choose a product"
                          filter
                          showClear
                          :filterPlaceholder="'Search'"
                          :modelValue="item.productId"
                          @change="
                            (e) => handleChangeEditedProductItem(e, index)
                          "
                        />
                      </td>

                      <td v-if="editedRow !== index">
                        {{ formatCurrency(item.price) }}
                      </td>

                      <td v-else>
                        <input
                          class="form-control"
                          placeholder="Harga"
                          :value="item.price"
                          disabled
                        />
                      </td>

                      <td v-if="editedRow !== index">
                        {{ item.quantity }}
                      </td>

                      <td v-else>
                        <input
                          class="form-control"
                          placeholder="Jumlah"
                          type="number"
                          min="1"
                          @change="
                            (e) => handleChangeEditedQuantityItem(e, index)
                          "
                          :value="item.quantity"
                        />
                      </td>

                      <td v-if="editedRow !== index">
                        {{ formatCurrency(item.quantity * item.price) }}
                      </td>

                      <td v-else>
                        <input
                          class="form-control"
                          placeholder="Total"
                          disabled
                          :value="formatCurrency(item.quantity * item.price)"
                        />
                      </td>

                      <td v-if="isEditPage && index !== editedRow">
                        <div class="" style="display: flex; gap: 10px">
                          <button
                            @click="() => handleOpenEditRow(item, index)"
                            class="btn btn-info fa fa-pencil"
                          />
                          <button @click="(e) => handleDeleteItem(item,index)" class="btn btn-danger fa fa-trash" />
                        </div>
                      </td>

                      <td
                        v-else-if="isEditPage"
                        style="display: flex; gap: 10px"
                      >
                        <button
                          @click="
                            () => {
                              editedRow = null;
                            }
                          "
                          class="btn btn-primary fa fa-save"
                        ></button>
                        <button
                          @click="() => handleCancelEdit(index)"
                          class="btn btn-warning fa fa-close"
                        ></button>
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

                  <button
                    v-if="isEditPage"
                    style="margin-top: 20px"
                    class="btn"
                    @click="() => (isAddNewItem = true)" 
                  >
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
                      disabled
                    />
                  </div>
                </div>
                <button @click="handleDownload" class="btn btn-info">
                  Download Invoices
                </button>
              </div>
            </div>
            <div class="col-lg-6 col-xs-12">
              <div
                v-if="!isEditPage"
                style="display: flex; flex-direction: column; gap: 20px"
              >
                <button
                  v-if="storeType === constant.storeType.branch && 
                 ( invoiceDetail.status === constant.invoiceStatus.rejected || 
                  invoiceDetail.status === constant.invoiceStatus.revised) "
                  @click="
                    () => {
                      isEditPage = true;
                    }
                  "
                  class="btn btn-warning"
                >
                  Edit
                </button>
                <button
                  @click="$router.push('/purchase-order')"
                  class="btn btn-danger"
                >
                  Cancel
                </button>
              </div>
              <div
                v-else
                class="flex-custom-responsive"
                style="display: flex; flex-direction: column; gap: 20px"
              >
                <button @click="handleSaveInvoices" class="btn btn-success">Save Invoices</button>
                <button @click="isEditPage = false" class="btn btn-danger">
                  Cancel
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </NuxtLayout>
  </div>
</template>

<script lang="ts" setup>
import type {
  Invoice,
  Product,
  InvoiceItem,
  InputFileEvent,
} from "~/helpers/interface";
import { useInvoicesStore, useDownloadInvoice, useProductStore } from "~/store";
import moment from "~~/plugins/moment";
import { Base64 } from "js-base64";
import { constant, formatCurrency } from "~/helpers";
import type { DropdownChangeEvent } from "primevue/dropdown";

interface NewInvoiceItem extends InvoiceItem {
  total: number;
}

const $moment = moment().provide.moment;
const $router = useRouter()

const { downloadInvoices } = useDownloadInvoice();
const { fetchInvoiceDetail, addInvoiceItems, deleteInvoiceItems } = useInvoicesStore();
const { fetchProduct } = useProductStore();

const route = useRoute();

const storeType: string = localStorage.getItem("storeType") || "";
const id: string = route.params?.id ? (route.params.id as string) : "";

const isEditPage = ref<boolean>(false);
const invoiceDetail = ref<Invoice>({
  invoiceDate: "",
  price: 0,
  totalItem: 0,
  type: "",
});
const editedRow = ref<number | null | undefined>(null);
const products = ref<Product[]>();
const defaultEditedValue = ref<NewInvoiceItem>({
  productId: "",
  quantity: 0,
  price: 0,
  total: 0,
});
const isAddNewItem = ref<boolean>(false);
const selectedProduct = ref<any>(null);
const newInvoiceItem = ref<NewInvoiceItem>({
productId: "",
quantity: 0,
price: 0,
total: 0,
});
const newItemsPayload = ref<InvoiceItem[]>([])
const deletedItemId = ref<string[]>([])

const totalPrice = computed(() => {
  let total = 0;
  invoiceDetail.value.invoiceItems?.forEach((item) => {
    total += Number(item.price) * Number(item.quantity);
  });

  return total;
});

const handleDeleteItem = (item:InvoiceItem, index:number) => {
  const itemId = item.id
  if (itemId) {
    deletedItemId.value.push(itemId)
  }

  const temp = [...<[]>invoiceDetail.value.invoiceItems]
  temp.splice(index, 1)

  invoiceDetail.value.invoiceItems = temp
}
const handleDownload = async () => {
  const invoiceId = invoiceDetail.value.id || "";
  const invoiceNumber = invoiceDetail.value.invoiceNumber;
  const invoice = await downloadInvoices(invoiceId);

  const buff = Base64.toUint8Array(invoice);
  const contentType = "application/pdf";

  const url = window.URL.createObjectURL(
    new Blob([buff], { type: contentType })
  );
  const link = document.createElement("a");
  link.setAttribute("download", `${invoiceNumber}.pdf`);

  link.href = url;
  link.click();
};

const handleSaveInvoiceItems = () => {
  const newItem: InvoiceItem = {
    productId: newInvoiceItem.value.productId,
    quantity: newInvoiceItem.value.quantity,
    price: newInvoiceItem.value.price,
    productName: newInvoiceItem.value.productName,
  };

  invoiceDetail.value.invoiceItems?.push(newItem);
  newItem.trxInvoicesId = invoiceDetail.value.id

  const newItemTemp = {...newItem}
  delete newItemTemp.productName

  newItemsPayload.value.push(newItemTemp)
  newInvoiceItem.value = {
    productId: "",
    quantity: 0,
    price: 0,
    total: 0,
  };
  selectedProduct.value = null
};


const handleSaveInvoices = async () => {
  const payload = {
    items : newItemsPayload.value
  }

  await addInvoiceItems(payload)
  await deleteInvoiceItems({
    invoicesItemsId : deletedItemId.value
  })

  $router.push('/purchase-order')
}
const handleChangeQuantity = (value: Event) => {
  const el = value as InputFileEvent;
  newInvoiceItem.value.quantity = Number(el.target.value);
  newInvoiceItem.value.total =
    newInvoiceItem.value.price * newInvoiceItem.value.quantity;
};

const handleFetchProductOptions = async (options: any) => {
  const fetchProductValue = await fetchProduct();
  products.value = fetchProductValue;
};

const handleChangeEditedProductItem = (
  event: DropdownChangeEvent,
  index: number
) => {
  const { value } = event;
  const product = products.value?.find((item: any) => item.id === value);
  if (
    invoiceDetail &&
    invoiceDetail.value &&
    invoiceDetail.value.invoiceItems
  ) {
    const tempEditedObject = invoiceDetail.value.invoiceItems[index];
    tempEditedObject.price = product?.sellingPrice || 0;
  }
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

const handleCancelEdit = (index: number) => {
  if (invoiceDetail.value && invoiceDetail.value.invoiceItems) {
    invoiceDetail.value.invoiceItems[index] = defaultEditedValue.value;
  }

  editedRow.value = null;
};

const handleChangeEditedQuantityItem = (event: Event, index: number) => {
  const el = event as InputFileEvent;
  const { value } = el.target;
  if (
    invoiceDetail &&
    invoiceDetail.value &&
    invoiceDetail.value.invoiceItems
  ) {
    const tempEditedObject = invoiceDetail.value.invoiceItems[index];
    tempEditedObject.quantity = Number(value) || 0;
  }
};

const handleOpenEditRow = (item: any, index: number) => {
  editedRow.value = index;
  const tempDefaultValue = { ...item };
  defaultEditedValue.value = tempDefaultValue;
};

onMounted(async () => {
  invoiceDetail.value = await fetchInvoiceDetail(id);
  await handleFetchProductOptions({});
});

// method

definePageMeta({
  layout: "dashboard",
});
</script>
