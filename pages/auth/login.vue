<template>
  <div id="single-wrapper" style="min-height: 100vh;" >
    <form action="#" class="frm-single">
      <div class="inside">
        <div class="title"><strong>Ninja</strong>Admin</div>
        <!-- /.title -->
        <div class="frm-title">Login</div>
        <!-- /.frm-title -->
        <div class="frm-input">
          <input type="text" placeholder="Username" class="frm-inp" /><i
            class="fa fa-user frm-ico"
          ></i>
        </div>
        <!-- /.frm-input -->
        <div class="frm-input">
          <input type="password" placeholder="Password" class="frm-inp" /><i
            class="fa fa-lock frm-ico"
          ></i>
        </div>
        <!-- /.frm-input -->
        <div class="clearfix margin-bottom-20">
          <div class="pull-left">
            <div class="checkbox primary">
              <input type="checkbox" id="rememberme" /><label for="rememberme"
                >Remember me</label
              >
            </div>
            <!-- /.checkbox -->
          </div>
          <!-- /.pull-left -->
        </div>
        <!-- /.clearfix -->
        <button type="submit" class="frm-submit">
          Login<i class="fa fa-arrow-circle-right"></i>
        </button>
        <div class="row small-spacing">
         
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

<style>
@import "../../assets/styles/style.min.css";
@import "../../assets/fonts/themify-icons/themify-icons.css";
@import "../../assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css";
@import "../../assets/plugin/waves/waves.min.css";
@import "../../assets/plugin/sweet-alert/sweetalert.css";

html,
body {
  font-family: "poppins";
}
</style>
