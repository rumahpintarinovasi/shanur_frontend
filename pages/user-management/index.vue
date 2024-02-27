<template>
  <div>
    <NuxtLayout>
      <div id="wrapper">
        <div class="main-content">
          <div class="row small-spacing">
            <div class="col-12">
              <div class="box-content">
                <h4>User Management</h4>
                <table
                  class=" table table-stripped margin-bottom-10 margin-top-10"
                >
                  <thead>
                    <tr>
                      <th>Name</th>
                      <th>Role</th>
                      <th>Store Name</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(user,index) in users" :key="index" >
                      <td v-if="index !== editedRow" >
                        {{ user.name }}
                      </td>
                      <td v-else >
                        <input type="text" :value="user.name" class="form-control" />
                      </td>
                      <td v-if="index !== editedRow" >
                        {{ user.role }}
                      </td>

                      <td v-else >
                        <select class="form-control" >
                          <option>Cashier</option>
                          <option>Staff</option>
                          <option>Store Owner</option>
                        </select>
                      </td>


                      <td v-if="index !== editedRow" >
                        {{ user.storeName }}
                      </td>
                      <td v-else >
                        <input type="text" class="form-control" :value="user.storeName" />
                      </td>

                      <td class="status-col" v-if="index !== editedRow" style="vertical-align: center; align-items: center;" >
                        <!-- {{ user.status }} -->
                        <Shanurbadge :text="user.status" :type="generateBadgeType(user.status)" />
                      </td>

                      <td class="status-col" v-else >
                        <select class="form-control" >
                          <option>Active</option>
                          <option>To Be Confirm</option>
                          <option>Deactive</option>
                        </select>
                      </td>

                      <td>
                        <div v-if="index !== editedRow" class="action-button-wrapper">
                            <button @click="() => handleOpenEditRow(index)" class="btn btn-info">
                              <i class="fa fa-pencil"></i>
                            </button>
                          <!-- <button class="btn btn-secondary">
                            <i class="fa fa-eye"> </i>
                          </button> -->
                        </div>

                        <div v-else class="action-button-wrapper" >
                          <button @click="() => handleOpenEditRow(null)" class="btn btn-warning">
                              <i class="fa fa-close"></i>
                            </button>


                          <button class="btn btn-success">
                            <i class="fa fa-save"> </i>
                          </button>

                          <button class="btn btn-danger" >
                            <i class="fa fa-trash" ></i>
                          </button>
                        </div>
                      </td>
                    </tr>                   
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </NuxtLayout>
  </div>
</template>

<script setup lang="ts">

import { type Users } from '~/helpers/interface'
definePageMeta({
  layout: "dashboard",
});

const editedRow = ref<Number|null>(null)
const users = ref<Users[] | []>([
  {
    name : 'Cashier 1',
    role : 'Cashier',
    storeName : 'Shanur Bontonompo',
    status : 'Confirmed'
  },
  {
    name: 'Staff Toko 1',
    role: 'Staff',
    storeName : 'Shanur Tanralili',
    status: 'To Be Confirm'
  },
  {
    name: 'Staff Toko 1',
    role: 'Store Manager',
    storeName : 'Shanur Tanralili',
    status: 'Rejected'
  }
])

const handleOpenEditRow = (index:Number|null) => {
  editedRow.value = index
}

const generateBadgeType = (status:String) => {
  switch (status) {
    case 'Confirmed':
      return 'success'
    case 'To Be Confirm':
      return 'warning'
    case 'Rejected':
      return 'failed'
    default:
      return 'success'
  }

  return ''
} 
</script>

<style scoped >
  .action-button-wrapper {
    display: flex;
    gap: 10px;
    align-items: center;
    justify-content: center;
  }

  td, th{
    /* vertical-align: middle; */
    text-align: center;
  }

  .center-vertical-align td{
    vertical-align: center !important;
  }

  .status-col {
    display: flex;
    justify-content: center;
  }
</style>
