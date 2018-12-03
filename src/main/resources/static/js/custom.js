
/*
 * navbar slide down animation
 */
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,true).slideDown("400");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,true).slideUp("400");
            $(this).toggleClass('open');       
        }
    );
});


$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	  
	  //displaying logout message with animation and hide
	  $('#logoutMessage').fadeOut(2000);
	  
	//displaying add success message with animation and hide
	  $('.message').fadeOut(2000);
	  
	
	  
	  /*
		 * data table
	  */
// --------------------------- Supplier info table-----------------------------------------
		var $table = $('#supplierInfoTable');
		console.log($table.length);
		if($table.length) {
			//console.log('inside the table');
			
			var jsonUrl ="/json/data/allSupplier";
			
			
			$table.dataTable({
				ajax: {
					url: jsonUrl,
					dataSrc: '',
					mDataProp: ''
					
				},
				aoColumns: [
					{
						mData: 'id'
					},
					{
						mData: 'name'
					},
					{
						mData: 'companyName'
					},
					{
						mData: 'id',
						bSortable: false,
						mRender: function(mData, type, row) {
							var str = "";
							str += "<a style='margin-right: 2px' href='/user/edit/"+mData+"/supplier' class='btn btn-xs btn-warning'>Edit</a>";
							str += "<button value='"+mData+"' class='btn btn-xs btn-danger deleteSupplier'>Delete</button>";
							return str;
						}
					}
				],
				initComplete: function() {
					var api = this.api();
					api.$('button.deleteSupplier').click(function() {
						
						var button = $(this);
						//getting the value of id from value button value tag
						var value = button.prop('value');
						
						bootbox.confirm({
							size: 'medium',
							title: 'Confirmation',
							message: 'Are You want to Delete this Supplier?',
							callback: function(confirmed) {
								if(confirmed) {
									//console.log(value);
									var activationUrl = '/user/delete/'+value+'/supplier';
                                    console.log(value);
									$.post(activationUrl, function(data) {
										
										bootbox.alert({
											size: 'medium',
											title: 'Message',
											message: data,
											callback: function(){
												//for refreshing the page
												window.location.reload();
											}
										});
										
									});
								}

							}
						
						});
					});
				},
				//"bSort": false,
				"bJQueryUI": true,
				"sPaginationType" : "full_numbers",
				"sScrollY": "200px",
				"bScrollCollapse": true,
				"paging": false,
				"info": false
				
				
			});
		}
		
		
		
	//------------------------ Customer info Table ------------------------------------
	    var $customerTable = $('#customerInfoTable');
		if ($customerTable.length) {
			console.log("inside the customer table");

			var jsonUrlCustomer = "/json/data/allCustomer";

			$customerTable.dataTable({
				ajax: {
					url:jsonUrlCustomer,
					dataSrc: '',
					mDataProp: ''
				},
				aoColumns: [
					{
						mData: 'id'
					},
                    {
                        mData: 'name'
                    },
                    {
                        mData: 'companyName'
                    },
                    {
                        mData: 'id',
						bSortable: false,
						mRender: function (mData, type, row) {
							var str = "";
							str += "<a href='/user/edit/"+mData+"/customer' class='btn btn-xs btn-warning' >Edit</a> ";
							str += "<button class='btn btn-xs btn-danger deleteCustomer' value='"+mData+"'>Delete</button>";
							return str;
                        }
                    }
				],
				initComplete: function () {
					var api = this.api();
					api.$('button.deleteCustomer').click(function () {
						var button = $(this);
						var value = button.prop('value');
						bootbox.confirm({
							size: "medium",
							title: "Warning",
							message: "Are You want to delete this customer? ",
							callback: function (confirmed) {
								if (confirmed) {
									//console.log("customer deleted");
									var activationUrl = "/user/delete/"+value+"/customer";
									$.post(activationUrl, function (data) {
										bootbox.alert({
											size: "medium",
											title: "Message",
											message: data,
											callback: function () {
												window.location.reload();
                                            }
										});
                                    });
								}
								else {
									console.log("canceled");
								}
                            }
						});
                    });
                },
				info:false,
				paging: false,
                sPaginationType : "full_numbers",
                sScrollY: "200px",
                bScrollCollapse: true


			});
		}
		
// --------------------- preparing data table for productItem ------------------------------
		var $productItemInfoTable = $('#productItemInfoTable');
		if($productItemInfoTable.length) {
			
			var jsonUrl = "/json/data/allProductItem";
			
			$productItemInfoTable.dataTable({
				ajax: {
					url: jsonUrl,
					dataSrc: "",
					mDataProp: ""
				},
				aoColumns: [
					{
						mData: "id"
					},
					{
						mData: 'productItemName'
					},
					{
						mData: 'notes'
					},
					{
						mData: 'id',
						bSortable: false,
						mRender:function(mData, type, row) {
                            var str = "";
                            str += "<a href='/user/edit/"+mData+"/productItem' class='btn btn-xs btn-warning' >Edit</a> ";
                            str += "<button class='btn btn-xs btn-danger deleteProductItem' value='"+mData+"'>Delete</button>";
                            return str;

						}
					}
				],
				initComplete: function() {
					var api = this.api();
					api.$('.deleteProductItem').click(function() {
						var button = $(this);
						var buttonValue = button.prop("value");
						bootbox.confirm({
							size: "medium",
							title: "Warning",
							message: "Are you want to delete this product item?",
							callback: function(confirmed){
								if(confirmed) {
									var activationUrl = "/user/delete/"+buttonValue+"/productItem";
									$.post(activationUrl, function (data) {
										bootbox.alert({
											size: "medium",
											title: "Message",
											message: data,
											callback: function () {
												window.location.reload();
                                            }
										});
                                    });
									
								}
							}	
						});
					});
				},
				info: false,
				paging: false,
				sPaginationType: "full_numbers",
				sScrollY: "200px",
				bScrollCollapse: true
				
				
			});
		}



		// -------------- Preparing data table for item model---------------------
		var $ItemModelInfoTable = $('#ItemModelInfoTable');
		if($ItemModelInfoTable.length) {

			var itemUrl = "/json/data/item/models";

			$ItemModelInfoTable.dataTable({
				ajax: {
					url: itemUrl,
					dataSrc: '',
					mDataProp: ''
				},
				aoColumns: [
					{
						mData: "id"
					},
					{
						mData: "modelCode"
					},
					{
						mData: "productItem.productItemName"
					},
					{
						mData: "id",
						bSortable: false,
						mRender: function (mData, type, row) {
                            var str = "";
                            str += "<a href='/user/edit/"+mData+"/itemModel' class='btn btn-xs btn-warning' >Edit</a> ";
                            str += "<button class='btn btn-xs btn-danger deleteItemModel' value='"+mData+"'>Delete</button>";
                            return str;
                        }
					}
				],
				initComplete: function () {
					var api = this.api();
					api.$('.deleteItemModel').click(function () {
						var button = $(this);
						var buttonValue = button.prop("value");

						bootbox.confirm({
							size: "medium",
							title: "Warning Message",
							message: "Are You want to delete this Item Model?",
							callback: function (confirmed) {
								if(confirmed) {
									var activationUrl = "/user/delete/"+buttonValue+"/itemModel";
									$.post(activationUrl, function (data) {
										bootbox.alert({
											size: "medium",
											title: "Message",
											message: data,
											callback: function () {
												window.location.reload();
                                            }
										})
                                    });
								}
                            }
						});
                    });
                },
				info: false,
				paging: false,
				sPaginationType: "full_numbers",
				sScrollY: "200px",
				bScrollCollapse: true

			})
		}

		//----------------------- preparing data table for ItemModelPrice-----------------
		var $itemModelPriceInfoTable = $('#ItemModelPriceInfoTable');
		if($itemModelPriceInfoTable.length) {
			var itemModelPriceUrl = "/json/data/item/modelPrices";
			$itemModelPriceInfoTable.dataTable({
				ajax: {
					url: itemModelPriceUrl,
					dataSrc: "",
					mDataProp: ""
				},
				aoColumns: [
					{
						mData: "id"
					},
                    {
                        mData: "itemModel.modelCode"
                    },
                    {
                        mData: "sellPrice"
                    },
                    {
                        mData: "buyPrice"
                    },
                    {
                        mData: "startDate"
                    },
                    {
                        mData: "id",
						bSortable: false,
						mRender: function (mData, type, row) {
                            var str = "";
                            str += "<a href='/user/edit/"+mData+"/itemModelPrice' class='btn btn-xs btn-warning' >Edit</a> ";
                            str += "<button class='btn btn-xs btn-danger deleteItemModelPrice' value='"+mData+"'>Delete</button>";
                            return str;
                        }
                    },
				],
				initComplete: function () {
					var api = this.api();
					api.$('.deleteItemModelPrice').click(function () {
						var button = $(this);
						var buttonValue = button.prop("value");
						bootbox.confirm({
							size: "medium",
							title: "Warning Message",
							message: "Are You want to delete this Item Model Price Info",
							callback: function (confirmed) {
								if(confirmed) {
									var activationUrl = "/user/delete/"+buttonValue+"/itemModelPrice";
									$.post(activationUrl, function (data) {
                                        bootbox.alert({
                                            size: "medium",
                                            title: "Message",
                                            message: data,
                                            callback: function () {
												window.location.reload();
                                            }
                                        })
                                    });
								}
                            }
						});
                    });
                },
				info: false,
				paging: false,
				sPaginationType: "full_numbers",
				sScrollY: "200px",
				bScrollCollapse: true
			})
		}
		
	  
});

// custom panel
$(document).ready(function() {
	//sliding part here
	// supplier slider
	$("#customSlide").click(function() {
		//console.log("clicked");
		$("#panelHidden").slideToggle(500);
	}); 
	// view supplier slider
	$("#customSlide2").click(function() {
		//console.log("clicked");
		
		$("#panelHidden2").slideToggle(500, function(){
			//for handling table rendering problem
			$('.autoClick').trigger("click");
			$('.autoClick').trigger("click");
		});
	}); 
	
	// customer slider
	$("#customerSlide").click(function() {
		//console.log("clicked");
		$("#customerPanelHidden").slideToggle(500);
	});
	// view customer slider
	$("#viewCustomerInfo").click(function() {
		//console.log("clicked");
		$("#viewCustomerPanel").slideToggle(500, function () {
            //for handling table rendering problem
            $('.autoClick').trigger("click");
            $('.autoClick').trigger("click");
        });
	});
	
	// product item slider
	$("#productItemSlide").click(function() {
		//console.log("clicked");
		$("#productItemPanelHidden").slideToggle(500);
	});
	//view product item slider
	$('#viewProductItemSlide').click(function() {
		$('#viewProductItemPanelHidden').slideToggle(500, function() {
			$('.autoClick').trigger("click");
            $('.autoClick').trigger("click");
		});
	});

	// item model slider
    $("#itemModelSlide").click(function() {
        //console.log("clicked");
        $("#itemModelPanelHidden").slideToggle(500);
    });
    //view ItemModel slider
    $('#viewItemModelSlide').click(function() {
        $('#viewItemModelPanelHidden').slideToggle(500, function() {
            $('.autoClick').trigger("click");
            $('.autoClick').trigger("click");
        });
    });


    // item model price slider
    $("#itemModelPriceSlide").click(function() {
        //console.log("clicked");
        $("#itemModelPricePanelHidden").slideToggle(500);
    });
    //view ItemModelPrice slider
    $('#viewItemModelPriceSlide').click(function() {
        $('#viewItemModelPricePanelHidden').slideToggle(500, function() {
            $('.autoClick').trigger("click");
            $('.autoClick').trigger("click");
        });
    });


	/*
		handle customer vat input by clicking on radio button
	 */
	$('#yesVat').click(function () {
		var seletecdValue='';
		$('#payVat').slideDown();

		//getting the value from the selector
        $('#vatPayer').change(function () {
            seletecdValue = $('#vatPayer :selected').text();
            //console.log(seletecdValue);
            $('#yesVat').val(seletecdValue);
            console.log($('[value]#yesVat').val());
        });

    });
    $('#noVat').click(function () {
        $('#payVat').slideUp();
    });



    // $(function() {
    //     $("#standard").customselect();
    // });

	// dropdown with search feature using bootstrap-selector
    $('.selectpicker').selectpicker({
        size: 4
    });


    //............................getting those model for particular product item using ajax...............

    function getModelByProductId(productId) {
        var $itemModels = $('#itemModels');
        //removing previous item model from list
        if($itemModels.length >0) {
            $('option').remove('.optionclass');
        }
        $.ajax({
            url: "/json/data/"+productId+"/item/models",
            method: "Get",
            success: function (data) {
                data.forEach(function (item) {
                    $('<option />', {
                        class: "optionclass",
                        html: item.modelCode,
						"value":item.id
                    }).appendTo($itemModels);
                })
            }
        });
    }

	$('#productItemId').on('change', function () {
		var productId = $(this).val();
		getModelByProductId(productId);
    })


	// ------------------------ Purchase Part ---------------------------------------------------------

    // getting invoice and bill no for purchase
    $.ajax({
        type: 'GET',
        url: '/user/getAllPurchase',
        success: function (data) {
            $('#billNo').val(data);
            $('#invoiceNo').val(data);
            //$('#invoiceNo').removeAttr("disabled");
        },
        error: function (e) {
            console.log("Failed to load data for bill no. "+e)
        }
    });


    $('#itemModel').change(function () {
		var id = $(this).val();

		if (id > 0) {
			// disable the input field
            $('#quantity').removeAttr('disabled');

            $('#quantity').change(function () {
				var qty = $(this).val();
				var airWayBill = $('#airWayBill').val();
				if (qty > 0 && id > 0) {
                    $('#rate').removeAttr('disabled');
                    $('#total').removeAttr('disabled');

                    // getting the product buy price from the controller
					$.ajax({
						type: 'POST',
						url:'/user/productBuyPrice/'+id,
						success: function (data) {
							$('#rate').val(parseFloat(data));
                        },
						error: function (e) {
							console.log("Failed to fetch buy price. ", e);
                        }

					})

                    //getting the total purchase value from the controller
                    $.ajax({
						type: 'POST',
						url: '/user/totalPurchase/'+id+'/'+qty,
						success: function (data) {
							var total = (parseFloat(data) + parseFloat(airWayBill));
							$('#total').val(total);

							//changing total while change the airway bill
							$('#airWayBill').change(function () {
                                var airWayChangedBill = $(this).val();
                                if (airWayChangedBill == '') {
                                	airWayChangedBill = 0.0;
								}
                                var changedTotal = parseFloat(data) + parseFloat(airWayChangedBill);
                                $('#total').val(changedTotal);

                                // changing net payment for changing airway bill
								var dueAmount = $('#due').val();
								if(dueAmount == '') {
									dueAmount = 0.0;
								}
                                var changedNetpayment = parseFloat(changedTotal) - parseFloat(dueAmount);

                                $('#netPayment').val(changedNetpayment);
                            });

							// enabling the net payment and due input field
                            $('#netPayment').removeAttr('disabled');
                            $('#due').removeAttr('disabled');

							$('#netPayment').val(total);

							// changing net payment for changing due amount
							$('#due').change(function () {
								var dueAmount = $(this).val();
								if (dueAmount == '') {
									dueAmount = 0;
								}

								var changedNetPayment = parseFloat($('#total').val()) - parseFloat(dueAmount);
                                $('#netPayment').val(changedNetPayment);
                            });
                        },
						error: function (e) {
							console.log("Failed to fetch total data from controller. "+e);
                        }
					});

				} else {
					$('#rate').attr('disabled', true);
					$('#total').attr('disabled', true);
					$('#netPayment').attr('disabled', true);
					$('#due').attr('disabled', true);

                    $('#rate').val('');
                    $('#total').val('');
                    $('#netPayment').val('');
                    $('#due').val('');
				}


            });

        } else {
            $('#quantity').attr('disabled', true);
            $('#rate').attr('disabled', true);
            $('#total').attr('disabled', true);
            $('#netPayment').attr('disabled', true);
            $('#due').attr('disabled', true);

            $('#quantity').val('');
            $('#rate').val('');
            $('#total').val('');
            $('#netPayment').val('');
            $('#due').val('');
		}


    });


    // --------------------------- Sales invoice Part ---------------------------------------------


	$.ajax({
		type: 'GET',
		url: '/updated-invoice-no',
		success: function (invoiceNo) {
			$('#invoiceUNo').val(invoiceNo);
        },
		error: function (e) {
			console.log('Failed to load invoice no.', e);
        }
	})


	$('#itemModelS').change(function () {

		var modelId = $(this).val();

        //setting disabled field value for each time when changing
        $('#discountS').val("0.0");
        $('#dueS').val("0.0");

        $('#rateS').val("");
        $('#totalS').val("");
        $('#netTotalS').val("");
        $('#netTotalS').val("");
        $('#paymentReceivedS').val("");

        $('#quantity').val("");

		if (modelId > 0) {
            // getting available quantity
            $.ajax({
                type: 'GET',
                url: "/item-model/" +modelId+ "/quantity",
                success: function (availableQty) {
                    $('#availablelQty').val(availableQty);

                    //$('#availablelQty').removeAttr('disabled');
                    $('#quantity').removeAttr('disabled');

                    // field effect for changing the quantity field
                    $('#quantity').change(function () {
						var qty = $(this).val();
						if (qty > 0) {

							// enabling fields
                            $('#dueS').removeAttr('disabled');
                            $('#discountS').removeAttr('disabled');
                            $('#unit').removeAttr('disabled');
							/*
							$('#rateS').removeAttr('disabled');
							$('#totalS').removeAttr('disabled');
							$('#netTotalS').removeAttr('disabled');
							$('#netTotalS').removeAttr('disabled');
							$('#paymentReceivedS').removeAttr('disabled');
							*/

							// getting the sales price from controller using ajax
                            $.ajax({
                                type: 'GET',
                                url: '/sell-price/'+modelId,
                                success: function (sellPrice) {

                                    $('#rateS').val(sellPrice);

                                    $.ajax({
                                        type: 'GET',
                                        url: '/total-sell-price/' +modelId+ "/"+qty,
                                        success: function (totalSellPrice) {
                                            //getting the unit value and calculate rate and other thing base on this
                                            var unit = $('#unit').val();
                                            if (unit == 'pcs') {
                                                var unitAmount = 1;
												$('#totalS').val(totalSellPrice);
												$('#netTotalS').val(totalSellPrice);
                                                $('#paymentReceivedS').val(totalSellPrice);
                                            }else {
                                                var unitAmount = 2;
                                                $('#totalS').val(totalSellPrice * unitAmount);
                                                $('#netTotalS').val(totalSellPrice * unitAmount);
                                                $('#paymentReceivedS').val(totalSellPrice * unitAmount);
                                            }
                                            
                                            // changing for unit re-arrenge fields
											$('#unit').change(function () {
												var changedUnit = $(this).val();
												if (changedUnit == 'pcs') {
                                                    var unitAmount = 1;
                                                    $('#totalS').val(totalSellPrice);

                                                    // update net total value with discount value
													var discount = $('#discountS').val();
													var updataNetTotal = totalSellPrice - discount;
                                                    $('#netTotalS').val(updataNetTotal);

                                                    // set payment received
													var dueAmount = $('#dueS').val();
													var updatePayment = updataNetTotal - dueAmount;
													$('#paymentReceivedS').val(updatePayment);
												}
												else {
                                                    var unitAmount = 2;
                                                    $('#totalS').val(totalSellPrice * unitAmount);

                                                    // update net total value with discount value
                                                    var discount = $('#discountS').val();
                                                    var updataNetTotal = (totalSellPrice * unitAmount) - discount;
                                                    //console.log("updated net total", updataNetTotal);
                                                    $('#netTotalS').val(updataNetTotal);

                                                    // set payment received
                                                    var dueAmount = $('#dueS').val();
                                                    var updatePayment = updataNetTotal - dueAmount;
                                                    $('#paymentReceivedS').val(updatePayment);
												}
                                            });

                                            // changing effect with updating discount
											$('#discountS').change(function () {

												var discount = $(this).val();
                                                if (discount == '') {
                                                    $(this).val('0.0')
                                                }
												var total = $('#totalS').val();
												var dueAmount = $('#dueS').val();

												// update net total with discount change
												$('#netTotalS').val(total - discount);

                                                // update payment received with discount change
												$('#paymentReceivedS').val($('#netTotalS').val() - dueAmount);


                                            });

                                            // changing effect with updating due amount
											$('#dueS').change(function () {

                                                var dueAmount = $(this).val();
                                                // if
                                                if (dueAmount == '') {
                                                    $(this).val('0.0')
												}
                                                // update payment received with due change
                                                $('#paymentReceivedS').val($('#netTotalS').val() - dueAmount);


                                            });

                                        },
										error: function (e) {
                                            console.log('Failed to fetch total sell price. ', e);
                                        }
									})


                                },
                                error: function (e) {
                                    console.log('Failed to fetch sell price. ', e);
                                }
                            });


						}
						else {
							// setting field as disabled
							$('#unit').attr('disabled', true);
                            $('#dueS').attr('disabled', true);
                            $('#discountS').attr('disabled', true);

                            /*
                            $('#rateS').attr('disabled', true);
                            $('#totalS').attr('disabled', true);
                            $('#netTotalS').attr('disabled', true);
                            $('#netTotalS').attr('disabled', true);
                            $('#paymentReceivedS').attr('disabled', true);
                            */

                            //setting disabled field value as empty
                            $('#discountS').val("0.0");
                            $('#dueS').val("0.0");

                            $('#rateS').val("");
                            $('#totalS').val("");
                            $('#netTotalS').val("");
                            $('#netTotalS').val("");
                            $('#paymentReceivedS').val("");


						}
                    });
                },
                error: function (e) {
                    console.log("Failed to fetch the quantity, "+ e);
                }
            })
		}
		else {
			//setting field value as empty
            $('#quantity').val("");
            $('#dueS').val("0.0");
            $('#discountS').val("0.0");
            $('#availablelQty').val("");

            $('#rateS').val("");
            $('#totalS').val("");
            $('#netTotalS').val("");
            $('#netTotalS').val("");
            $('#paymentReceivedS').val("");

            // setting fields as disabled
            $('#quantity').attr("disabled", true);
            $('#unit').attr('disabled', true);
            $('#discountS').attr('disabled', true);
            $('#dueS').attr('disabled', true);
            /*
            $('#availablelQty').attr("disabled", true);
            $('#quantity').attr("disabled", true);
            $('#rateS').attr('disabled', true);
            $('#totalS').attr('disabled', true);
            $('#netTotalS').attr('disabled', true);
            $('#netTotalS').attr('disabled', true);
            $('#paymentReceivedS').attr('disabled', true);
            */
		}
    });


	// ------------------------------ sales invoice confirm ------------------------------------------------
	//var qty = $('#confirmQty').val();

    var selecteParticularProduct = $('#selectParticularProduct');
    //by default the select particular product should be hide
    $('#sellFromHideWrapper').hide();
    selecteParticularProduct.change(function () {
        var isChecked = selecteParticularProduct.prop('checked');
        //console.log("check :", isChecked);
        if (isChecked) {
            $('#sellFromHideWrapper').show();

            var macListsPage = $('#unsoldMac');
            if (macListsPage.length) {
                var modelId = $('#modelId').val();
                console.log("model", modelId);
                $.ajax({
                    type: "GET",
                    url: "/all-unsold-mac/item-model/"+modelId,
                    success: function (macLists) {

                        for (var i = 0; i<macLists.length; i++) {
                            var mac = macLists[i];
                            //console.log("mac:", mac.macId);
                            var option = new Option(mac.macId+"", mac.macId+"");
                            //var selectElement = '<option value="'+mac.macId+'">'+mac.macId+'</option>';
                            $('#unsoldMac').append($(option));
                        }
                        //refreshing select picker otherwise search feature will not work
                        $('.selectpicker').selectpicker('refresh');
                    },
                    error: function (er) {
                        console.log(er);
                    }
                });
            }
        } else  {
        	// clear the select options after select and then deselect
            var len = $('#unsoldMac').length;
            for (var i = 0; i< len; i++) {
                $('#unsoldMac').remove();
			}
			// hide the select dropdown
            $('#sellFromHideWrapper').hide();
        }
    });




	// --------------------- return portion ------------------------------------------------------------


    // by default all three table will be hidden
    $('#purchaseReturnTable').hide();
    $('#salesReturnTable').hide();
    $('#returnWithMacTable').hide();
    $('#sMessage').hide();
    $('#pMessage').hide();
    $('#mMessage').hide();

    // hiding return type dropdown menu, its only will show when user click invoice radio button.
    $('#hideReturnType').hide();

    $('#searchWithMac').click(function () {
        $('#hideReturnType').slideUp();
        $('#searchKey').attr('placeholder', 'Mac');
    });

    // some changes when click on invoice radio
    $('#searchWithInvoice').click(function () {
        $('#hideReturnType').slideDown();
        $('#searchKey').attr('placeholder', 'Sell Invoice');

        $('#returnType').change(function () {
			var returnType = $(this).val();

			if (returnType == 'sell') {

				$('#searchKey').attr('placeholder', 'Sell Invoice');


			}else {
                $('#searchKey').attr('placeholder', 'Purchase Invoice');
			}

        });
    });


    // search mechanism------------------------

	$('#returnSearchBtn').click(function () {
        var invoiceNo = $('#searchKey').val();

        // search with mac
        if ($('#searchWithMac').prop('checked') == true) {
            //console.log('mac');

			var macId = $('#searchKey').val();
            console.log(macId);
            // getting the macList by the macId
			$.ajax({
				url: '/user/macList/by/'+macId,
                type: 'GET',
				success: function (data) {
                    if (data == "" || data == null || data == undefined) {
                        $('#returnWithMacTable').hide();
                        $('#mMessage').show();
                    } else {
                        $('#returnWithMacTable').show();
                        $('#mMessage').hide();

                        console.log(data.sellStatus);
					}
                },
				error: function (er) {
					alert(er);
                }
			});


        }

        //search with invoice
        if ($('#searchWithInvoice').prop('checked') == true) {
            //console.log("invoice");

            var returnType = $('#returnType').val();
            if (returnType == 'sell') {
                //console.log("data: ");
                $('#purchaseReturnTable').hide();
                $.ajax({
                    url: "/invoice/"+invoiceNo+"/sell-info",
                    type: "GET",
                    success: function (salesInvoice) {
                        //console.log("data: "+salesInvoice);

						if (salesInvoice == "" || salesInvoice == null || salesInvoice == undefined) {
                            //console.log("empty");
                            $('#salesReturnTable').hide();
                            $('#sMessage').show();
						} else {
                            $('#sMessage').hide();
                            $('#salesReturnTable').show();

                            if (parseInt(salesInvoice.quantity ) != 0) {
                                $('#sDate').text("Date: "+getFormatedDate(new Date()));
                                $('#customerName').text("Customer Name: "+salesInvoice.customer.name);
                                $('#salesModelName').text(salesInvoice.model.productItem.productItemName);
                                $('#salesModelCode').text(salesInvoice.model.modelCode);
                                $('#salesAvQty').text(salesInvoice.availableQty+" pcs");
                                $('#salesRate').text(salesInvoice.rate);


                                $('#returnSellBtn').click(function () {
                                    var quantity = $('#sellReturnQty').val();
                                    $('#sellReturnUrl').attr('href', "/user/return-sell/"+salesInvoice.id+"/quantity/"+quantity);
                                });
							} else {
                                $('#salesAvQty').text("Already Returned");
                                $('#salesAvQty').css('color', 'red');
                                $('#returnSellBtn').hide();
                                $('#sellReturnQty').hide();

                                $('#sDate').text("Date: "+new Date());
                                $('#customerName').text("Customer Name: "+salesInvoice.customer.name);
                                $('#salesModelName').text(salesInvoice.model.productItem.productItemName);
                                $('#salesModelCode').text(salesInvoice.model.modelCode);
                                $('#salesRate').text(salesInvoice.rate);
							}
						}
                    },
                    error: function (e) {
                        console.log(e);
                        alert(e);
                    }
                });

            }else {
                $('#salesReturnTable').hide();
                $('#pMessage').show();

            	$.ajax({
					url: '/invoice/'+invoiceNo+'/purchase-info',
					type: 'GET',
					success : function (purchase) {
                        if (purchase == "" || purchase == null || purchase == undefined) {
                            console.log("empty");
                            $('#purchaseReturnTable').hide();
                            $('#pMessage').show();
                        } else {
                            $('#pMessage').hide();
                            $('#purchaseReturnTable').show();

                            if (parseInt(purchase.quantity) != 0) {
                                $('#pDate').text("Date: "+new Date());
                                $('#supplierName').text("Supplier Name: "+purchase.supplier.name);
                                $('#purchaseModelName').text(purchase.model.productItem.productItemName);
                                $('#purchaseModelCode').text(purchase.model.modelCode);
                                $('#purchaseAvQty').text(purchase.availableQty+" pcs"); // getting current available qty
                                $('#purchaseRate').text(purchase.rate);


                                $('#purchaseReturnBtn').click(function () {
                                    var quantity = $('#purchaseReturnQty').val();
                                    $('#purchaseReturnUrl').attr('href', "/user/return-purchase/"+purchase.id+"/quantity/"+quantity);
                                });
                            }
						}
                    },
					error: function (er) {
						console.log(er);
						alert(er);
                    }
				});


            }



        }

    });





	function printLayer(layer) {
        var generator = window.open(",'name,");
        var layerText = document.getElementById(layer);
        generator.document.write(layerText.innerHTML.replace("Print Me"))

        generator.document.close();

        generator.print();
        generator.close();
    }
    
    function getFormatedDate(date) {

		var months = ['Jan', 'Feb', "Mar", 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

		var day = date.getDate();
		var monthIndex = date.getMonth();
		var year = date.getFullYear();

		return day+" "+months[monthIndex]+" "+ year;

    }




});