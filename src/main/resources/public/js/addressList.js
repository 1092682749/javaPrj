var saveAddressDiv = document.getElementById('saveAddressDiv');
var closeImg = document.getElementById('closeImg');
var addTitle = document.getElementById('addTitle');
var editAddress = document.getElementsByClassName('editAddress')[0];
var detailAddressInput = document.getElementById('detailAddressInput');
var linkPhoneInput = document.getElementById('linkPhoneInput');
var memberNameInput = document.getElementById('memberNameInput');
var addAddressDiv = document.getElementById('addAddressDiv');
var addressForm = document.getElementById('addressForm');
var addressIdInput = document.getElementById('addressIdInput');
var flag = true;
addAddressDiv.onclick = function () {
    flag = false;
    addTitle.innerHTML="新增收货地址";
    editAddress.style.display = "block";
    memberNameInput.removeAttribute('value');
    linkPhoneInput.removeAttribute('value');
    detailAddressInput.removeAttribute('value');
};
closeImg.onclick = function(){
    editAddress.style.display = "none";
};
function displayBox(id) {
    flag = true;

    addTitle.innerHTML="编辑收货地址";
    editAddress.style.display = "block";
    var addressDiv = document.getElementById(id);
    var memberName = addressDiv.getElementsByClassName('memberName')[0];
    var memberPhone = addressDiv.getElementsByClassName('memberPhone')[0];
    var memberAddress = addressDiv.getElementsByClassName('memberAddress')[0];
    addressIdInput.setAttribute("value",id);
    console.log(addressIdInput);
    memberNameInput.setAttribute("value" , memberName.innerHTML);
    linkPhoneInput.setAttribute("value" , memberPhone.innerHTML);
    detailAddressInput.setAttribute("value" , memberAddress.innerHTML);
    console.log(addressDiv);
    console.log(memberName);
}
saveAddressDiv.onclick = function () {
  //需要表单验证
     if (flag)
     {
         addressForm.setAttribute("action","/address/update")

     }else {
         addressForm.setAttribute("action","/address/add")

     }
    addressForm.submit();
    console.log(addressForm);

};

