$(document).ready(function(){

	// for styling css
    $.validator.setDefaults({
       highlight: function (element) {
           $(element)
               .closest(".form-group")
               .addClass("has-error help-block")
       },
        unhighlight:function (element) {
            $(element)
                .closest(".form-group")
                .removeClass("has-error help-block")
        }
    });

//------------------------- validate supplier form ------------------------------------
    var $supplierForm = $('#supplierForm');
    if($supplierForm.length) {
    	console.log("inside supplier form");
        $supplierForm.validate({
            rules:{
                name: {
                    required: true
                },
                companyName:{
                    required: true
                },
                address: {
                    required: true
                },
                phone: {
                    required: true
                },
                fax: {
                    required: true
                },
                mobile: {
                    required: true,
                    digits: true
                },
                web: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                }



            },
            messages:{
                name: {
                    required: "Please enter supplier name!"
                },
                companyName:{
                    required: "Please enter company name!"
                },
                address: {
                    required: "Please fill up supplier address!"
                },
                phone: {
                    required: "Please fill up supplier phone!"
                },
                fax: {
                    required: "Please fill up fax!"
                },
                mobile: {
                    required: "Please enter mobile number!",
                    digits: "Please enter digit only!"
                },
                web: {
                    required: "Please enter web address!"
                },
                email: {
                    required: "Please enter email address!",
                    email: "Please enter valid email address!"
                }
            }
        });


    }


// ---------------------------- validate customer form ----------------------------------------
    var $customerForm = $('#customerForm');
    if($customerForm.length) {
        console.log("customer form is exist");
        $customerForm.validate({
            rules:{
                name: {
                    required: true,
                    minlength: 3
                },
                companyName:{
                    required: true
                },
                address: {
                    required: true
                },
                phone: {
                    required: true
                },
                fax: {
                    required: true
                },
                mobile: {
                    required: true,
                    number: true
                },
                web: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                payVat: {
                    required: true
                },
                tax: {
                    required: true
                },
                tpInvoice:{
                    required: true
                },
                ceInvoice: {
                    required: true
                }


            },
            messages:{
                name: {
                    required: "Please enter supplier name!",
                    minlength: "Please enter at least 3 character!"
                },
                companyName:{
                    required: "Please enter company name!"
                },
                address: {
                    required: "Please fill up supplier address!"
                },
                phone: {
                    required: "Please fill up supplier phone!"
                },
                fax: {
                    required: "Please fill up fax!"
                },
                mobile: {
                    required: "Please enter mobile number!",
                    number: "Please enter number only!"
                    	
                },
                web: {
                    required: "Please enter web address!"
                },
                email: {
                    required: "Please enter email address!",
                    email: "Please enter valid email address!"
                },
                payVat: {
                    required: "Please select one option!"
                },
                tax: {
                    required: "Please select one option!"
                },
                tpInvoice:{
                    required: "Please enter TP invoice!"
                },
                ceInvoice: {
                    required: "Please enter CE invoice!"
                }
            }
        });
        
        
    }
    
    
 // ------------------------- validation for productItem form ---------------------------
    var $productItemForm = $('#productItemForm');
    if($productItemForm.length) {
    	$productItemForm.validate({
    		rules: {
    			productItemName: {
    				required: true
    			}
    		},
    		messages: {
    			productItemName: {
    				required: "Please enter product item name!"
    			}
    		}
    	});
    }

    // ------------------------- validation for ItemModel form ---------------------------
    var $itemModelForm = $('#itemModelForm');
    if($itemModelForm.length) {
        $itemModelForm.validate({
            rules: {
                modelCode: {
                    required: true
                }
            },
            messages: {
                modelCode: {
                    required: "Please enter item model code!"
                }
            }
        });
    }

    // ------------------------- validation for ItemModelPrice form ---------------------------
    var $itemModelPriceForm = $('#itemModelPriceForm');
    if($itemModelPriceForm.length) {
        $itemModelPriceForm.validate({
            rules: {
                buyPrice: {
                    required: true
                },
                sellPrice: {
                    required: true
                }
            },
            messages: {
                buyPrice: {
                    required: "Please enter buy price!"
                },
                sellPrice: {
                    required: "Please enter sell price!"
                }
            }
        });
    }


    // ----------------- validating purchase form ---------------------------------
    var $purchaseForm = $('#purchaseForm');

    if ($purchaseForm.length) {

        $purchaseForm.validate({
            rules: {
                billNo: {
                    required: true
                },
                invoiceNo: {
                    required: true
                },
                'model.id': {
                    required: true
                },
                quantity: {
                    required: true
                },
                rate: {
                    required: true
                },
                total: {
                    required: true
                },
                netPayment: {
                    required: true
                }


            },
            messages: {
                billNo: {
                    required: "Please enter bill no."
                },
                invoiceNo: {
                    required: "Please enter invoice no."
                },
                'model.id': {
                    required: "Please select model."
                },
                quantity: {
                    required: "Please enter quantity"
                },
                rate: {
                    required: "Rate field should not be empty."
                },
                total: {
                    required: "Total field should not be empty."
                },
                netPayment: {
                    required: "Net payment field should not be empty."
                }
            }
        });

    }


});