import { constant } from '../helpers'

function formatCurrency(amount: number): string {
  if (!amount) {
    return `Rp. 0`;
  }
  const [integerPart, decimalPart] = amount.toFixed(2).split(".");
  const formattedIntegerPart = integerPart.replace(
    /\B(?=(\d{3})+(?!\d))/g,
    ","
  );

  return `Rp ${formattedIntegerPart}${decimalPart ? "." + decimalPart : ""}`;
}

function setUserPayload(payload: string) {
  const parseData = JSON.parse(payload);
  const { role, storeId, userName } = parseData;
  localStorage.setItem("role", role);
  localStorage.setItem("storeId", storeId);
  localStorage.setItem("userName", userName);
}

interface InvoiceItems {
  name: String;
  price: Number;
  unit: String;
  qty: Number;
}

const generateInvoiceTemplate = ({
  items,
  totalPrice,
  totalQuantity,
}: {
  items: InvoiceItems[];
  totalPrice: number;
  totalQuantity: number;
}) => {
  const invoicesTemplate = `

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <div class="head-invoices">
            <p class="header1" >Shanur Head Office</p>
            <p>Invoices</p>
            <p>08131323123123  Gowa</p>
        </div>
    
    
        <div class="information-invoices">
            <p>Nomor Faktur : 132123132</p>
            <p>Tanggal transaksi : 23 Maret 2024 12:23:21</p>
            <p>Nama Kasir : John Doe</p>
        </div>
    
        <div class="table-invoice">
            <table>
                <tr>
                    <th>Nama Barang</th>
                    <th>Harga</th>
                    <th>Satuan</th>
                    <th>Kuantitas</th>
                    <th>Total</th>
                </tr>

                ${items.map(
                  (item) =>
                    `
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.unit || ""}</td>
                            <td>${item.qty}</td>
                            <td>${+item.price * +item.qty}</td>
                        </tr>
                        `
                )}
    
                <tr>
                    <td></td>
                    <td></td>
                    <td><h4>Total</h4></td>
                    <td> ${totalQuantity} </td>
                    <td>${totalPrice}</td>
                </tr>
    
            </table>
        </div>
    </body>
    
    <style>
        * {
            margin: 0;
        }
    
        th {
            border-top:  1px solid black;
            border-bottom:  1px solid black;
            padding-top: 5px;
            padding-bottom: 5px;
        }
    
        td {
            text-align: center;
            padding-top: 5px;
            padding-bottom: 5px;
        }
    
        .last-row {
            border-bottom: 1px solid black;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        .head-invoices {
            /* background-color: red; */
            display: flex;
            flex-direction: column;
            gap: 5px;
            align-items: center;
        }
    
        .header1 {
            font-size: 24px;
        }
    
        .information-invoices {
            /* background-color: blue; */
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            gap: 5px;
        }
    
        .table-invoice {
            margin-top: 20px;
        }
    </style>
    `;

  console.log(invoicesTemplate);
  return invoicesTemplate;
};

const generateBadgeType = (status: String) => {
  switch (status) {
    case constant.invoiceStatus.done:
        return 'primary'
    case constant.invoiceStatus.processed:
        return 'info'
    case "Confirmed":
    case constant.invoiceStatus.approved:
      return "success";
    case "Requested":
    case "To Be Confirm":
      return "warning";
    case "Rejected":
      return "failed";
    default:
      return "failed";
  }
};

export {
  formatCurrency,
  setUserPayload,
  generateInvoiceTemplate,
  generateBadgeType,
  // downloadPDF
};
