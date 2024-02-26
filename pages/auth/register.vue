<template>
    <div id="single-wrapper">
      <form action="#" class="frm-single">
        <div class="inside">
          <div class="title">SHANUR</div>
          <!-- /.title -->
          <div class="frm-title">Register</div>
          <!-- /.frm-title -->
          <div class="frm-input">
            <input type="text" v-model="nameUser" placeholder="Name" class="frm-inp" /><i
              class="fa fa-user frm-ico"
            ></i>
          </div>
          <div class="frm-input">
            <input type="email" v-model="email" placeholder="Email" class="frm-inp" /><i
              class="fa fa-envelope frm-ico"
            ></i>
          </div>
          <!-- /.frm-input -->
          <div class="frm-input">
            <input type="text" v-model="username" placeholder="Username" class="frm-inp" /><i
              class="fa fa-user frm-ico"
            ></i>
          </div>
          <!-- /.frm-input -->
          <div class="frm-input">
            <input type="password" v-model="password" placeholder="Password" class="frm-inp" /><i
              class="fa fa-lock frm-ico"
            ></i>
          </div>
          <!-- SELECT ROLE -->
            <div class="frm-input">
                <select class="frm-inp" v-model="roleSelected">
                <option value="" disabled>Select Role</option>
                <option v-for="role in roles" :key="role.id" :value="role.id">{{ role.name }}</option>
                </select>
                <i class="fa fa-user
                frm-ico"></i>
            </div>
          <button type="button" @click="handleSubmit" class="frm-submit">
            Register<i class="fa fa-arrow-circle-right"></i>
          </button>
          <!-- /.row -->
          <NuxtLink to="/auth/login" class="a-link"
            ><i class="fa fa-sign-in"></i>Already have account? Login.</NuxtLink
          >
          <div class="frm-footer">SHANUR 2022.</div>
          <!-- /.footer -->
        </div>
        <!-- .inside -->
      </form>
      <!-- /.frm-single -->
    </div>
</template>

<script setup>

import { useToast } from "vue-toast-notification";
import "vue-toast-notification/dist/theme-sugar.css";

import { storeToRefs } from 'pinia'
import { useUserStore } from '~/store/user';


const $toast = useToast();
const $router = useRouter()

const userStore = useUserStore()

const { registerUser } = userStore

const roles = await userStore.getRoles();

const nameUser = ref('')
const email = ref('')
const username = ref('')
const password = ref('')
const roleSelected = ref('')

const handleSubmit = async (e) => {
  e.preventDefault()

  try {
    await registerUser({
      name: nameUser.value,
      email: email.value,
      userName: username.value,
      password: password.value,
      roleId: roleSelected.value
    })

    $toast.open({
      message: 'User registered successfully',
      type: 'success',
      position: 'top',
      duration: 5000
    })

    $router.push('/auth/login')

  } catch (error) {
    console.log(error)
    $toast.open({
      message: error.response.data.message,
      type: 'error',
      position: 'top',
      duration: 5000
    })
  }
  
}


</script>


<style>
@import "../../assets/styles/style.min.css";
@import "../../assets/fonts/themify-icons/themify-icons.css";

html,
body {
  font-family: "poppins";
}
</style>