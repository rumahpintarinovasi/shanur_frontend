const constant = {
  userStatus: {
    confirmed: "Confirmed",
    toBeConfirm: "To Be Confirm",
    Rejected: "Rejected",
  },
  sideBarMenu: {
    cashier: ["Dashboard", "Invoice", "Stock", "Cashier"],
    superAdmin: [
      "Dashboard",
      "Purchase Order",
      "Invoice",
      "Stock",
      "Product",
      "User Management",
      "Customer Management",
      "Cashier",
    ],
    staff: [
      "Dashboard",
      "Purchase Order",
      "Invoice",
      "Stock",
      "Product",
      "Customer Management",
    ],
  },
  invoiceStatus: {
    done : 'Done',
    processed : 'Processed',
    requested: "Requested",
    revised: "Revised",
    rejected: "Rejected",
    approved: "Approved",
  },
  storeType: { branch: "branch", warehouse: "warehouse" },
};

export { constant };
