<template>
  <div id="single-wrapper" style="min-height: 100vh;" >
    <form action="#" class="frm-single">
      <div class="inside">
        <div class="title">SHANUR</div>
        <!-- /.title -->
        <div class="frm-title">Login</div>
        <!-- /.frm-title -->
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
        <!-- /.frm-input -->

        <!-- /.clearfix -->
        <button type="submit" class="frm-submit" @click="handleSubmit">
          Login<i class="fa fa-arrow-circle-right"></i>
        </button>


        
        <div class="row small-spacing text-center">
          <NuxtLink to="/auth/register" class="a-link"
            ><i class="fa fa-user-plus"></i>Don't have account? Register.</NuxtLink
          >
        </div>
        <!-- /.row -->
        
        <div class="frm-footer text-center">SHANUR 2022.</div>
        <!-- /.footer -->
      </div>
      <!-- .inside -->
    </form>
    <!-- /.frm-single -->
  </div>
</template>

<script setup>
import Button from 'primevue/button';
import { useToast } from "vue-toast-notification";
import "vue-toast-notification/dist/theme-sugar.css";

import { storeToRefs } from 'pinia'
import { useUserStore } from '~/store/user';


const $toast = useToast();
const $router = useRouter()

const userStore = useUserStore()

const { loginUser } = userStore

const username = ref('')
const password = ref('')

const handleSubmit = async (e) => {
  e.preventDefault()

  try {
    const response = await loginUser({
      password: password.value,
      userName: username.value,
    })

    $toast.open({
      message: 'Login successfully',
      type: 'success',
      position: 'top',
      duration: 5000
    })

    localStorage.setItem('authorizeToken', response.token)
    $router.push('/')
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
