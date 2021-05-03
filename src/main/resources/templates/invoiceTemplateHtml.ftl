<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Invoice Email</title>


    <style>
        .invoice-box {
            max-width: 800px;
            margin: auto;
            padding: 30px;
            border: 1px solid #eee;
            box-shadow: 0 0 10px rgba(0, 0, 0, .15);
            font-size: 16px;
            line-height: 24px;
            font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
            color: #555;
            min-height: 850px;
            max-widht: 863px;
        }

        .invoice-box table {
            width: 100%;
            line-height: inherit;
            text-align: left;
        }

        .invoice-box table td {
            padding: 5px;
            vertical-align: top;
        }


        .invoice-box table tr.top table td {
            padding-bottom: 20px;
        }

        .invoice-box table tr.top table td.title {
            font-size: 45px;
            line-height: 45px;
        }

        * {
            color: #333;

        }

        .invoice-box table tr.information table td {
            padding-bottom: 40px;
        }

        .invoice-box table tr.heading td {
            background: #eee;
            border-bottom: 1px solid #ddd;
            font-weight: bold;
        }

        .invoice-box table tr.details td {
            padding-bottom: 20px;
        }

        .invoice-box table tr.item td {
            border-bottom: 1px solid #eee;
        }

        .invoice-box table tr.item.last td {
            border-bottom: none;
        }


        .boldfont {
            border-top: 2px solid #eee;
            font-weight: bold;
        }

        .text-right {
            text-align: right;
        }

        @media only screen and (max-width: 600px) {
            .invoice-box table tr.top table td {
                width: 100%;
                display: block;
                text-align: center;
            }

            .invoice-box table tr.information table td {
                width: 100%;
                display: block;
                text-align: center;
            }
        }

        /** RTL **/
        .rtl {
            direction: rtl;
            font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
        }

        .rtl table {
            text-align: right;
        }

        .rtl table tr td:nth-child(2) {
            text-align: left;
        }

    </style>
</head>

<body>
<p style="text-align: left;">Dear ${invoice.appointment.patient.name},</p>
<p style="text-align: left;">This is the invoice for your latest appointment, also a PDF version is attached to this email
if you wish to download and print it. </p>
<p style="text-align: left; margin-bottom: 10px;">Thank you for visiting Care And Cure Clinics.</p>
<div class="invoice-box">
    <table cellpadding="0" cellspacing="0">
        <tr class="top">
            <td colspan="2">
                <table>
                    <tr>
                        <td class="title">
                            <img style="width:250px;" width="250px"
                                 src="https://carecureclinics.com/assets/logo%20only.png"/>
                        </td>

                        <td class=" text-right">
                            <span> Invoice #: ${code} </span><br/>
                            <span> Created: ${dateCreated}</span>


                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr class="information">
            <td colspan="2">
                <table>
                    <tr>
                        <td>
                            Patient Name: ${invoice.appointment.patient.name}<br/>
                            Doctor Name: ${invoice.appointment.doctor.name}<br/>
                            Appointment Code: ${invoice.appointment.code}<br/>
                            Speciality: ${invoice.appointment.speciality}<br/>
                            Payment Method: ${invoice.paymentMethod}<br/>
                            Status: ${invoice.status}
                        </td>

                        <td class=" text-right">
                            Total Due: ${invoice.totalDue} EGP<br/>
                            <#if 0 < discount >
                                <span>

                                    Discount: ${discount}%

                            </span><br/>
                            </#if>

                            <#if 0 < discount >
                                <span>Amount Discounted:
                                ${invoice.totalDue-invoice.totalAfterDiscount} EGP</span><br/>
                            </#if>
                            <#if 0 < discount >
                                <span>Total After Discount:${invoice.totalAfterDiscount}
                                EGP</span><br/>
                            </#if>
                            <span>Total Paid: ${invoice.totalPaid} EGP</span><br/>
                            <span>Total Remaining: ${invoice.totalRemaining} EGP</span>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>


        <tr class="heading">
            <td>
                Item
            </td>

            <td class="boldfont text-right">
                Price
            </td>
        </tr>
        <#list invoice.invoiceItems as item>
            <tr class="item">
                <td>
                    ${item.name}
                </td>

                <td class=" text-right">
                    ${item.price} EGP
                </td>
            </tr>
        </#list>


        <tr class="total">
            <td></td>

            <td class="boldfont text-right">
                Total: ${invoice.totalDue} EGP
            </td>
        </tr>
    </table>
</div>
</body>
</html>