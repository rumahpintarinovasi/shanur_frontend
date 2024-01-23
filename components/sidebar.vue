<template>
    <div class="navigation">
			<h5 class="title">Main Menu</h5>
			<!-- /.title -->
			<ul class="menu js__accordion">
				<li>
					<NuxtLink to="/"><i class="menu-icon ti-dashboard"></i><span>Dashboard</span></NuxtLink>
				</li>
				<li @click="handleMenuItemClick(0)" :class="{ active: activeIndex === 0 }">
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon ti-bar-chart"></i><span>Laporan</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content" :style="{ display: activeIndex === 0 ? 'block' : 'none' }">
						<li><a href="#">Laporan Penjualan</a></li>
						<li><a href="#">Laporan Pembelian</a></li>
						<li><a href="#">Kartu Stock</a></li>
						<li>
							<NuxtLink to="/purchase-order">Purchase Order</NuxtLink>
						</li>
						<li><a href="#">Faktur Pembelian</a></li>
						<li><a href="#">Retur Pembelian</a></li>
						<li><a href="#">Faktur Penjualan</a></li>
						<li><a href="#">Retur Penjualan</a></li>
						<li><a href="#">Laporan Hutang</a></li>
						<li><a href="#">Laporan Piutang</a></li>
						<li><a href="#">Laporan Laba/Rugi</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
			</ul>
			<!-- /.menu js__accordion -->
			<h5 class="title">User Interface</h5>
			<!-- /.title -->
			<ul class="menu js__accordion">
				<li @click="handleMenuItemClick(1)" :class="{ active: activeIndex === 1 }">
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon ti-flag"></i><span>Icons</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content" :style="{ display: activeIndex === 1 ? 'block' : 'none' }">
						<li><a href="icons-font-awesome-icons.html">Font Awesome</a></li>
						<li><a href="icons-fontello.html">Fontello</a></li>
						<li><a href="icons-material-icons.html">Material Design Icons</a></li>
						<li><a href="icons-material-design-iconic.html">Material Design Iconic Font</a></li>
						<li><a href="icons-themify-icons.html">Themify Icons</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
				<li  @click="handleMenuItemClick(2)" :class="{ active: activeIndex === 2 }">
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon ti-desktop"></i><span>UI Kit</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content" :style="{ display: activeIndex === 2 ? 'block' : 'none' }">
						<li><a href="ui-buttons.html">Buttons</a></li>
						<li><a href="ui-cards.html">Cards</a></li>
						<li><a href="ui-checkbox-radio.html">Checkboxs-Radios</a></li>
						<li><a href="ui-components.html">Components</a></li>
						<li><a href="ui-draggable-cards.html">Draggable Cards</a></li>
						<li><a href="ui-modals.html">Modals</a></li>
						<li><a href="ui-notification.html">Notification</a></li>
						<li><a href="ui-range-slider.html">Range Slider</a></li>
						<li><a href="ui-sweetalert.html">Sweet Alert</a></li>
						<li><a href="ui-treeview.html">Tree view</a></li>
						<li><a href="ui-typography.html">Typography</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
				<li @click="handleMenuItemClick(3)" :class="{ active: activeIndex === 3 }">
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon ti-layout"></i><span>Forms</span><span class="notice notice-blue">7</span></a>
					<ul class="sub-menu js__content" :style="{ display: activeIndex === 3 ? 'block' : 'none' }">
						<li><a href="form-elements.html">General Elements</a></li>
						<li><a href="form-advanced.html">Advanced Form</a></li>
						<li><a href="form-fileupload.html">Form Uploads</a></li>
						<li><a href="form-validation.html">Form Validation</a></li>
						<li><a href="form-wizard.html">Form Wizard</a></li>
						<li><a href="form-wysiwig.html">Wysiwig Editors</a></li>
						<li><a href="form-xeditable.html">X-editable</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
				<li @click="handleMenuItemClick(4)" :class="{ active: activeIndex === 4 }">
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon ti-layout-accordion-merged"></i><span>Tables</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content" :style="{ display: activeIndex === 4 ? 'block' : 'none' }">
						<li><a href="tables-basic.html">Basic Tables</a></li>
						<li><a href="tables-datatable.html">Data Tables</a></li>
						<li><a href="tables-responsive.html">Responsive Tables</a></li>
						<li><a href="tables-editable.html">Editable Tables</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
			</ul>
			<!-- /.menu js__accordion -->
			<h5 class="title">Additions</h5>
			<!-- /.title -->
			<ul class="menu js__accordion">
				<li>
					<a class="waves-effect" href="profile.html"><i class="menu-icon ti-user"></i><span>Profile</span></a>
				</li>
				<li>
					<a class="waves-effect" href="inbox.html"><i class="menu-icon ti-email"></i><span>Mail</span><span class="notice notice-danger">New</span></a>
				</li>
				<li  @click="handleMenuItemClick(5)" :class="{ active: activeIndex === 5 }">
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon ti-layers"></i><span>Page</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content" :style="{ display: activeIndex === 5 ? 'block' : 'none' }">
						<li class="current"><a href="page-starter.html">Starter Page</a></li>
						<li><a href="page-login.html">Login</a></li>
						<li><a href="page-register.html">Register</a></li>
						<li><a href="page-recoverpw.html">Recover Password</a></li>
						<li><a href="page-lock-screen.html">Lock Screen</a></li>
						<li><a href="page-confirm-mail.html">Confirm Mail</a></li>
						<li><a href="page-404.html">Error 404</a></li>
						<li><a href="page-500.html">Error 500</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
				<li  @click="handleMenuItemClick(6)" :class="{ active: activeIndex === 6 }">
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon ti-blackboard"></i><span>Extra Pages</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content" :style="{ display: activeIndex === 6 ? 'block' : 'none' }">
						<li><a href="extras-contact.html">Contact list</a></li>
						<li><a href="extras-email-template.html">Email template</a></li>
						<li><a href="extras-faq.html">FAQ</a></li>
						<li><a href="extras-gallery.html">Gallery</a></li>
						<li><a href="extras-invoice.html">Invoice</a></li>
						<li><a href="extras-maps.html">Maps</a></li>
						<li><a href="extras-pricing.html">Pricing</a></li>
						<li><a href="extras-projects.html">Projects</a></li>
						<li><a href="extras-taskboard.html">Taskboard</a></li>
						<li><a href="extras-timeline.html">Timeline</a></li>
						<li><a href="extras-tour.html">Tour</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
			</ul>
			<!-- /.menu js__accordion -->
		</div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: null,
    };
  },
  methods: {
    handleMenuItemClick(index) {
      if (this.activeIndex === index) {
        // If the clicked menu is already active, close it
        this.activeIndex = null;
      } else {
        // Toggle the clicked menu
        this.activeIndex = index;
      }
    },
  },
};
</script>


<style scoped>
@import "../assets/styles/style.min.css";
@import "../assets/fonts/themify-icons/themify-icons.css";
@import "../assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css";
@import "../assets/plugin/waves/waves.min.css";
@import "../assets/plugin/sweet-alert/sweetalert.css";

.sub-menu-active {
	  display: block !important;
}

</style>

