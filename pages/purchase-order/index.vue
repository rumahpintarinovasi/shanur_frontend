<template>
  <div>
    <NuxtLayout>
      <div id="wrapper">
        <div class="main-content">
          <!-- /.row small-spacing two -->

          <div class="row small-spacing">
            <!-- Kartu Stok -->
            <div class="col-12">
              <div class="box-content">
                <div class="flex-custom">
                  <h4 class="box-title">Riwayat PO</h4>
                  <NuxtLink
                    to="/purchase-order/tambah"
                    class="btn btn-sm"
                    style="color: black; margin-bottom: 10px"
                  >
                    <i class="fa fa-plus"></i>

                    Buat PO
                  </NuxtLink>
                </div>

                <button
                  class="btn btn-sm"
                  @click="showFilter = !showFilter"
                  style="color: black; margin-bottom: 10px"
                >
                  <i class="fa fa-filter"></i>
                  Filter
                </button>

                <!-- contain filter -->
                <div class="custom-filter" :class="{ show: showFilter }">
                  <!-- search name input and button search -->

                  <div class="card flex justify-content-center">
                    <Dropdown
                      v-model="selectedUniqData"
                      :options="unitData"
                      optionLabel="name"
                      placeholder="Pilih Tipe PO"
                      class="w-full md:w-14rem"
                    />
                  </div>
                  <!-- clear filter -->
                  <button
                    class="btn btn-sm"
                    @click="selectedUniqData = null"
                    style="color: black; margin-bottom: 10px"
                  >
                    <i class="fa fa-times"></i>
                    Clear Filter
                  </button>
                </div>

                <table
                  class="table table-striped margin-bottom-10 margin-top-10"
                >
                  <thead>
                    <tr>
                      <th>Type</th>
                      <th>Date</th>
                      <th>Inv Number</th>
                      <th>Quantity</th>
                      <th>Total Price</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody v-if="invoices.length" >
                    <tr v-for="(invoice, index) in invoices" :key="index">
                      <td>{{ invoice.type }}</td>
                      <td>
                        {{
                          $moment(invoice.invoiceDate).format("DD MMMM YYYY")
                        }}
                      </td>
                      <td>{{ invoice.invoiceNumber || "-" }}</td>
                      <td>{{ invoice.totalItem }}</td>
                      <td>{{ formatCurrency(Number(invoice.price)) }}</td>
                      <td>
                        <Shanurbadge
                          v-if="index !== editedRow"
                          :text="invoice.status || ''"
                          :type="generateBadgeType(invoice.status)"
                        />

                        <select
                          v-else
                          class="form-control"
                          name="status"
                          :value="invoice.status"
                          @change="(e) => handleChangeStatus(e, index)"
                        >
                          <option selected disabled>Select Status</option>
                          <option :value="invoiceStatus.approved">
                            {{ invoiceStatus.approved }}
                          </option>

                          <option :value="invoiceStatus.requested">
                            {{ invoiceStatus.requested }}
                          </option>

                          <option :value="invoiceStatus.revised">
                            {{ invoiceStatus.revised }}
                          </option>

                          <option :value="invoiceStatus.rejected">
                            {{ invoiceStatus.rejected }}
                          </option>
                        </select>
                      </td>
                      <td>
                        <div
                          v-if="index !== editedRow"
                          style="display: flex; gap: 10px"
                        >
                          <button
                            @click="
                              $router.push(
                                `/purchase-order/detail/${invoice.id}`
                              )
                            "
                            class="btn btn-info"
                          >
                            <i class="fa fa-eye"></i>
                          </button>
                          <button
                            v-if="storeType === constant.storeType.warehouse"
                            @click="handleOpenEditRow(index)"
                            class="btn btn-warning"
                          >
                            <i class="fa fa-pencil"></i>
                          </button>
                        </div>

                        <div v-else class="" style="display: flex; gap: 10px">
                          <button
                            @click="
                              () => handleSaveStatus(invoice.id || '', index)
                            "
                            :disabled="loadingPage"
                            class="btn btn-success"
                          >
                            <i
                              class="fa fa-save"
                            >
                            </i>
                          </button>
                          <button
                            v-if="storeType === constant.storeType.warehouse"
                            @click="
                              () => {
                                editedRow = null;
                              }
                            "
                            class="btn btn-danger"
                          >
                            <i class="fa fa-close"></i>
                          </button>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>

                <div v-if="!invoices.length" style="display: flex; justify-content: center;">
                  <h5>Tidak ada data</h5>
                </div>

                <Pagination
                  :totalPages="totalPages"
                  @handleChangePage="handleChangePage"
                  :page="currentPages"
                />
              </div>
              <!-- /.box-content -->
            </div>
          </div>

          <Footer />
        </div>
      </div>
    </NuxtLayout>
  </div>
</template>

<script lang="ts" setup>
import Dropdown from "primevue/dropdown";
import type {
  Invoice,
  RequestPayload,
  InputFileEvent,
} from "../../helpers/interface";
import { useInvoicesStore } from "~/store/invoices";
// import { formatCurrency, generateBadgeType } from "../../helpers/utils";
import { formatCurrency, generateBadgeType, constant } from "../../helpers";
import moment from "~~/plugins/moment";

const { invoiceStatus } = constant;

const storeId = localStorage.getItem("storeId") || "";
const storeType = localStorage.getItem("storeType") || "";
const $moment = moment().provide.moment;
definePageMeta({
  layout: "dashboard",
});
const invoices = ref<Invoice[] | []>([]);
const totalPages = ref<Number>(1);
const currentPages = ref<Number>(1);
const totalData = ref<Number>(0);
const selectedUniqData = ref(null);
const loadingPage = ref(false);
const unitData = [
  { name: "Return", value: "Return" },
  { name: "Purchase Order", value: "Purchase Order" },
];
const editedRow = ref<Number | null>(null);
const handleOpenEditRow = (index: Number | null) => {
  editedRow.value = index;
};

const showFilter = ref(false);

watch(selectedUniqData, async () => {
  if (selectedUniqData.value === null) {
    const paramFetchInvoice = {
      whereConditions: [],
    };
    const result = await fetchInvoices(paramFetchInvoice);
    invoices.value = result.data;
    totalData.value = result.meta.totalData;
  } else {
    const paramFetchInvoice = {
      whereConditions: [`{"type" : "${selectedUniqData.value?.value}"}`],
    };
    const result = await fetchInvoices(paramFetchInvoice);
    invoices.value = result.data;
    totalData.value = result.meta.totalData;
  }
});

const invoicesStore = useInvoicesStore();
const { fetchInvoices, updateInvoice } = invoicesStore;

const handleFetchPO = async (options: RequestPayload) => {
  options.storeId = storeId;
  const filter = { ...options.whereConditions };
  filter.slug = "PO";
  let stringFilter = [];
  for (let key in filter) {
    stringFilter.push(JSON.stringify({ [key]: filter[key] }));
  }
  options.whereConditions = stringFilter;

  console.log(options);

  const fetchingPO = await fetchInvoices(options);
  invoices.value = fetchingPO.data;
  totalData.value = fetchingPO.meta.totalData;
  totalPages.value = Math.ceil(Number(totalData.value) / 10);
};

const handleSaveStatus = async (invoiceNumber: string, index: number) => {
  loadingPage.value = true;
  try {
    const payload = {
      status: invoices.value[index].status,
    };

    await updateInvoice(payload, invoiceNumber);
    await handleFetchPO({});

    editedRow.value = null;
  } catch (error) {
  } finally {
    loadingPage.value = false;
  }
};

const handleChangeStatus = (e: Event, index: number) => {
  const el = e as InputFileEvent;
  const { value, name } = el.target;

  switch (name) {
    case "status":
      invoices.value[index][name] = value;
      break;

    default:
      break;
  }
};

const handleChangePage = (page: Number) => {
  currentPages.value = page;
  handleFetchPO({
    page: Number(page),
    size: 10,
  });
};

onMounted(async () => {
  await handleFetchPO({
    page: 1,
    size: 10,
  });
});
</script>

<style>
p {
  margin: 0 !important;
}

.flex-custom {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
.flex-custom {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.custom-filter {
  display: flex !important;
  width: 100%;
  flex-direction: row;
  gap: 10px;
  transition: all 0.24s;
  transform: scaleY(0);
}

.custom-filter.show {
  transform: scaleY(1);
  transition: all 0.24s;
  display: flex !important;
  display: flex;
  width: 100%;
  flex-direction: row;
}

@media (max-width: 516px) {
  .custom-filter {
    flex-direction: row;
    gap: 10px;
  }
}

@media (max-width: 516px) {
  .flex-custom {
    flex-direction: column;
    justify-content: start;
    align-items: start;
    gap: 14px;
  }
}
.flex-custom h4.box-title {
  margin: 0;
}

.content-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.content-list .list {
  display: flex;
  padding: 8px 6px;
  background: #eee;
  justify-content: space-between;
  align-items: center;
}

.content-list .list .right {
  color: red;
}

.custom-laba {
  padding: 16px;
  border-radius: 6px;
  font-size: 28px;
  text-align: center;
}

.content-list-two {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.content-list-two .list {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 6px;
}

.content-list-two .list .left {
  background-color: #eee;
  padding: 8px 6px;
  border-radius: 6px;
  width: 100%;
}

.content-list-two .list .right {
  background: rgb(224, 176, 86);
  padding: 6px;
  border-radius: 8px 6px;
  min-width: max-content;
  max-width: max-content;
}
</style>
