<template>
  <div>
    <NuxtLayout>
      <div id="wrapper">
        <div class="main-content">
          <div class="row small-spacing">
            <div class="col-12">
              <div class="box-content">
                <button
                  class="btn btn-sm"
                  style="color: black; margin-bottom: 10px"
                >
                  <i class="fa fa-filter"></i>
                  Filter
                </button>

                <div class="custom-filter">
                  <div class="input-group" style="display: flex; gap: 5px">
                    <input
                      class="form-control"
                      placeholder="Nama User"
                      style="max-width: 180px; max-height: 40px"
                    />

                    <div class="input-group-append">
                      <button
                        class="btn btn-info"
                        style="padding: 8px 12px; height: 40px"
                      >
                        <i class="fa fa-search"></i>
                      </button>
                    </div>
                  </div>
                </div>
                <h4>User Management</h4>
                <table
                  class="table table-stripped margin-bottom-10 margin-top-10"
                >
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>Name</th>
                      <th>Role</th>
                      <th>Store Name</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(user, index) in users" :key="index">
                      <td>{{ index + 1 }}</td>
                      <td v-if="index !== editedRow">
                        {{ user.name }}
                      </td>
                      <td v-else>
                        <input
                          name="name"
                          @change="(e) => handleChangeForm(e, index)"
                          type="text"
                          :value="user.name"
                          class="form-control"
                        />
                      </td>
                      <td v-if="index !== editedRow">
                        {{ user.role }}
                      </td>
                      <td v-else>
                        <select
                          class="form-control"
                          @change="(e) => handleChangeForm(e, index)"
                          name="roleId"
                          :value="user.roleId"
                        >
                          <option selected disabled>Select Role</option>
                          <option
                            v-for="(role, index) in roles"
                            :key="index"
                            :value="role.id"
                          >
                            {{ role.name }}
                          </option>
                        </select>
                      </td>

                      <td v-if="index !== editedRow">
                        {{ user.storeName }}
                      </td>
                      <td v-else>
                        <select
                          @change="(e) => handleChangeForm(e, index)"
                          name="storeId"
                          class="form-control"
                          :value="user.storeId"
                        >
                          <option selected disabled>Select Store</option>
                          <option
                            v-for="(store, index) in stores"
                            :key="index"
                            :value="store.id"
                          >
                            {{ store.name }}
                          </option>
                        </select>
                      </td>

                      <td
                        class="status-col"
                        v-if="index !== editedRow"
                        style="vertical-align: center; align-items: center"
                      >
                        <!-- {{ user.status }} -->
                        <Shanurbadge
                          :text="user.status"
                          :type="generateBadgeType(user.status)"
                        />
                      </td>

                      <td class="status-col" v-else>
                        <select
                          class="form-control"
                          @change="(e) => handleChangeForm(e, index)"
                          name="status"
                          :value="user.status"
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
                        <div
                          v-if="index !== editedRow"
                          class="action-button-wrapper"
                        >
                          <button
                            @click="() => handleOpenEditRow(index)"
                            class="btn btn-info"
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
                            @click="() => handleSaveEditUser(index)"
                          >
                            <i
                              :class="`fa ${isLoading ? 'fa-spin' : 'fa-save'}`"
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
                  @handleChangePage="handleChangePage"
                  :page="currentPages"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </NuxtLayout>
  </div>
</template>

<script setup lang="ts">
import type {
  User,
  Store,
  InputFileEvent,
  Role,
  RequestPayload,
} from "~/helpers/interface";
import { constant } from "~/helpers/constant";
import { useUserStore, useStoresStore, useRoleStore } from '~/store'
import Swal from "sweetalert2";


definePageMeta({
  layout: "dashboard",
});

const { userStatus } = constant;
const { fetchUser, updateUserByAdmin } = useUserStore();
const { fetchStore } = useStoresStore();
const { fetchRoles } = useRoleStore();

const editedRow = ref<Number | null>(null);
const users = ref<User[] | []>([]);
const stores = ref<Store[] | []>([]);
const roles = ref<Role[] | []>([]);
const isLoading = ref<Boolean>(false);
const totalPages = ref<Number>(1);
const currentPages = ref<Number>(1);
const totalData = ref<Number>(0)

const handleOpenEditRow = (index: Number | null) => {
  editedRow.value = index;
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

const handleFetchUser = async (options: RequestPayload) => {
  const fetchingUser = await fetchUser(options);
  users.value = fetchingUser.data
  totalData.value = fetchingUser.meta.totalData
  totalPages.value = Math.ceil(Number(totalData.value) / 10);
};

const handleChangeForm = (e: Event, index: number) => {
  const el = e as InputFileEvent;
  const { value, name } = el.target;

  switch (name) {
    case "name":
    case "roleId":
    case "storeId":
    case "status":
      users.value[index][name] = value;
      break;

    default:
      break;
  }
};

const handleSaveEditUser = async (index: number) => {
  try {
    const userId = users.value[index].id || "";
    const editedUser = users.value[index];
    const payload = {
      roleId: editedUser.roleId || "",
      storeId: editedUser.storeId || "",
      status: editedUser.status || "",
      name: editedUser.name,
    };

    await updateUserByAdmin(payload, userId);
    editedRow.value = null;
    await handleFetchUser({
      whereConditions: "",
      page: Number(currentPages.value),
      size: 10,
    });

    Swal.fire({
      icon: "success",
      text: "Success Change Users Value",
    });
  } catch (error) {}
};

const handleChangePage = async (index: number) => {
  currentPages.value = index;
  await handleFetchUser({ whereConditions: "", page: index, size: 10 });
};

onMounted(async () => {
  await handleFetchUser({
    page: Number(currentPages.value),
    size: 10,
    whereConditions: "",
  });
  // users.value = await fetchUser({});
  stores.value = await fetchStore({});
  roles.value = await fetchRoles({});
});
</script>

<style scoped>
.action-button-wrapper {
  display: flex;
  gap: 10px;
  align-items: center;
  justify-content: center;
}

td,
th {
  /* vertical-align: middle; */
  text-align: center;
}

.center-vertical-align td {
  vertical-align: center !important;
}

.status-col {
  display: flex;
  justify-content: center;
}
</style>
