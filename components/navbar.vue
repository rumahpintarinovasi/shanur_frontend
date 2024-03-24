<template>
<div class="fixed-navbar">
	<div class="pull-left">
		<button
		@click="htmlAddMenuActive" 
		type="button" class="menu-mobile-button glyphicon glyphicon-menu-hamburger js__menu_mobile"></button>
		<h1 class="page-title">Home</h1>
		<!-- /.page-title -->
	</div>
	<!-- /.pull-left -->
	<div class="pull-right">
		<div class="ico-item">
			<a href="#" class="ico-item ti-search js__toggle_open" data-target="#searchform-header"></a>
			<form action="#" id="searchform-header" class="searchform js__toggle"><input type="search" placeholder="Search..." class="input-search"><button class="ti-search button-search" type="submit"></button></form>
			<!-- /.searchform -->
		</div>
		<!-- /.ico-item -->
		<a href="#" class="ico-item ti-bell notice-alarm js__toggle_open" data-target="#notification-popup"></a>
		<div class="ico-item">
			<i class="ti-user"></i>
			<ul class="sub-ico-item">
				<li><a href="#">Settings</a></li>
				<li><a class="js__logout" href="#" @click="logout">Log Out</a></li>
			</ul>
			<!-- /.sub-ico-item -->
		</div>
	</div>
	<!-- /.pull-right -->
</div>
</template>

<script>
export default {
  methods: {
    htmlAddMenuActive() {
	  document.querySelector('html').classList.toggle('menu-active');
	},
	logout() {
		localStorage.removeItem('authorizeToken');
		localStorage.removeItem('userId')
		localStorage.removeItem('userName')
		localStorage.removeItem('role')
		localStorage.removeItem('storeId')
		localStorage.removeItem('storeType')
		this.$router.push('/login');
	}
  },
};
</script>


  
