<template>
  <div class="">
    <NuxtLayout>
      <div class="wrapper">
        <div class="main-content">
          <div class="row small-spacing">
            <div class="col-12">
              <div class="box-content">
                <h4>Customer Management</h4>
                <table
                  class="table table-stripper margin-bottom-10 margin-top-10"
                >
                  <thead>
                    <th>No</th>
                    <th>Name</th>
                    <th>Level</th>
                    <th>Phone Number</th>
                    <th>Status</th>
                    <th>Action</th>
                  </thead>

                  <tbody>
                    <tr v-for="(customer, index) in customers" :key="index">
                      <td>
                        {{ ((Number(currPages) - 1 ) * 10 )+ index + 1 }}
                      </td>

                      <td v-if="index !== editedRow">
                        {{ customer.name }}
                      </td>
                      <td v-else>
                        <input class="form-control" />
                      </td>

                      <td v-if="index !== editedRow">
                        {{ customer.level }}
                      </td>
                      <td v-else>
                        <input class="form-control" />
                      </td>

                      <td>
                        {{ customer.phoneNumber }}
                      </td>

                      <td></td>

                      <td>
                        <div class="action-button-wrapper"></div>
                        <button class="btn btn-info">
                          <i class="fa fa-pencil"></i>
                        </button>
                      </td>
                    </tr>
                  </tbody>
                </table>
                <Pagination 
                    :totalPages="totalPages"
                    :page="currPages"
                    @handleChangePage="handleChangePage"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </NuxtLayout>
  </div>
</template>

<script lang="ts" setup>
import type { Customer, RequestPayload } from "~/helpers/interface";
import { useCustomerStore } from "~/store";
definePageMeta({
  layout: "dashboard",
});

const { totalData: customerTotalData, fetchCustomers } = useCustomerStore();

const customers = ref<Customer[] | null>(null);
const totalData = ref<Number>(0);
const currPages = ref<Number>(1);
const editedRow = ref<Number | null>(null);
const totalPages = ref<Number>(1);

const handleFetchCustomer = async (options: RequestPayload) => {
  const cust = await fetchCustomers(options);
  customers.value = cust;
  totalData.value = customerTotalData;
  console.log(totalData.value)
  totalPages.value = Math.ceil(Number(totalData.value) / 10)
};

const handleChangePage = async (index: number) => {
    currPages.value = index
    await handleFetchCustomer({ whereConditions : '', page: index, size : 10})
}

onMounted(async () => {
  await handleFetchCustomer({
    page: Number(currPages.value),
    size: 10,
    whereConditions: "",
  });
});
</script>


<style>
td,
th {
  /* vertical-align: middle; */
  text-align: center;
}


</style>