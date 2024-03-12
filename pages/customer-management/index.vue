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
                      <td class="" >
                        {{ ((Number(currPages) - 1 ) * 10 )+ index + 1 }}
                      </td>

                      <td>
                        {{ customer.name }}
                      </td>
  

                      <td v-if="index !== editedRow">
                        {{ customer.level }}
                      </td>
                      <td v-else>
                        <input name="level" @change="(e) => handleChangeForm(e, index)" :value="customer.level" class="form-control" type="number" />
                      </td>

                      <td>
                        {{ customer.phoneNumber }}
                      </td>

                      <td 
                        class="status-col" 
                        v-if="index !== editedRow"
                        style="vertical-align: center; align-items: center"
                      >
                        <Shanurbadge 
                          :text="customer.status"
                          :type="generateBadgeType(customer.status)"
                        />
                      </td>

                      <td class="status-col" v-else>
                        <select
                          class="form-control"
                          name="status"
                          :value="customer.status"
                          @change="(e) => handleChangeForm(e, index)"
                        >
                          <option selected disabled>Select Store</option>
                          <option :value="userStatus.confirmed">
                            {{ userStatus.confirmed }}
                          </option>
                          <option :value="userStatus.toBeConfirm">
                            {{ userStatus.toBeConfirm }}
                          </option>
                          <option :value="userStatus.Rejected">
                            {{ userStatus.Rejected }}
                          </option>
                        </select>
                      </td>

                      <td>
                        <div  v-if="index !== editedRow" class="action-button-wrapper">
                          <button 
                            class="btn btn-info"
                            @click="() => handleOpenEditRow(index)"
                          >
                            <i class="fa fa-pencil"></i>
                          </button>
                      
                        </div>

                        <div v-else class="action-button-wrapper">
                          <button
                            @click="() => handleOpenEditRow(null)"
                            class="btn btn-warning"
                          >
                            <i class="fa fa-close"></i>
                          </button>

                          <button
                            class="btn btn-success"
                          >
                            <i
                              :class="`fa ${false ? 'fa-spin' : 'fa-save'}`"
                            >
                            </i>
                          </button>

                          <button class="btn btn-danger">
                            <i class="fa fa-trash"></i>
                          </button>
                        </div>
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
import type { Customer, InputFileEvent, RequestPayload } from "~/helpers/interface";
import { useCustomerStore } from "~/store";
import { constant } from "~/helpers/constant";

definePageMeta({
  layout: "dashboard",
});

const { fetchCustomers,editCustomer } = useCustomerStore();
const { userStatus } = constant;

const customers = ref<Customer[] | null>(null);
const totalData = ref<Number>(0);
const currPages = ref<Number>(1);
const editedRow = ref<Number | null>(null);
const totalPages = ref<Number>(1);

const handleFetchCustomer = async (options: RequestPayload) => {
  const cust = await fetchCustomers(options);
  customers.value = cust.data;
  totalData.value = cust.meta.totalData;
  totalPages.value = Math.ceil(Number(totalData.value) / 10)
};

const generateBadgeType = (status: String) => {
  switch (status) {
    case "Confirmed":
      return "success";
    case "To Be Confirm":
      return "warning";
    case "Rejected":
      return "failed";
    default:
      return "success";
  }
};


const handleChangePage = async (index: number) => {
    currPages.value = index
    await handleFetchCustomer({ whereConditions : '', page: index, size : 10})
}

const handleChangeForm = (e :Event, index: number) => {
  const el = e as InputFileEvent
  const { value , name } = el.target

  switch (name) {
    case 'level':
    case 'status':
      if (customers.value) {
        customers.value[index][name] = value
      }
      break
  
    default:
      break;
  }
}

const handleSaveEdit = async (index: number) => {
  try {
    const customer = customers.value ? customers.value[index] : null
    const customerId = customer?.id  || ''
    const payload = {
      level : customer?.level,
      status : customer?.status
    }

    const editedValue = await editCustomer(payload, customerId)


  } catch (error) {
    
  }

}

const handleOpenEditRow = (index: Number | null) => {
  editedRow.value = index;
};
onMounted(async () => {
  await handleFetchCustomer({
    page: Number(currPages.value),
    size: 10,
    whereConditions: "",
  });
});
</script>


<style scoped>
td,
th {
  /* vertical-align: middle; */
  text-align: center;
}

.status-col {
  display: flex;
  justify-content: center;
}

.action-button-wrapper {
  display: flex;
  gap: 10px;
  align-items: center;
  justify-content: center;
}

</style>