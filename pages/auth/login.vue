<template>
  <div id="single-wrapper">
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
          <div class="pull-right">
            <a href="page-recoverpw.html" class="a-link"
              ><i class="fa fa-unlock-alt"></i>Forgot password?</a
            >
          </div>
          <!-- /.pull-right -->
        </div>
        <!-- /.clearfix -->
        <button type="submit" class="frm-submit">
          Login<i class="fa fa-arrow-circle-right"></i>
        </button>
        <div class="row small-spacing">
          <div class="col-sm-12">
            <div class="txt-login-with txt-center">or login with</div>
            <!-- /.txt-login-with -->
          </div>
          <!-- /.col-sm-12 -->
          <div class="col-sm-6">
            <button
              type="button"
              class="btn btn-sm btn-icon btn-icon-left btn-social-with-text btn-facebook text-white waves-effect waves-light"
            >
              <i class="ico fa fa-facebook"></i><span>Facebook</span>
            </button>
          </div>
          <!-- /.col-sm-6 -->
          <div class="col-sm-6">
            <button
              type="button"
              class="btn btn-sm btn-icon btn-icon-left btn-social-with-text btn-google-plus text-white waves-effect waves-light"
            >
              <i class="ico fa fa-google-plus"></i>Google+
            </button>
          </div>
          <!-- /.col-sm-6 -->
        </div>
        <!-- /.row -->
        <a href="/auth/register" class="a-link"
          ><i class="fa fa-sign-in"></i>New to Shanur? Register..</a
        >
        <div class="frm-footer">SHANUR 2022.</div>
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
