var editImg = document.getElementById('editImg');
var deleteImg = document.getElementById('deleteImg');
var closeImg = document.getElementById('closeImg');
var addTitle = document.getElementById('addTitle');
var editAddress = document.getElementsByClassName('editAddress')[0];
var memberName = document.getElementById('memberName');
var memberPhone = document.getElementById('memberPhone');
var memberAddress = document.getElementById('memberAddress');
var detailAddressInput = document.getElementById('detailAddressInput');
var linkPhoneInput = document.getElementById('linkPhoneInput');
var memberNameInput = document.getElementById('memberNameInput');
var addAddressDiv = document.getElementById('addAddressDiv');
var addressForm = document.getElementById('addressForm');
var flag = true;
addAddressDiv.onclick = function () {
    flag = false;
    editAddress.style.display = "block";
    // memberNameInput.value = "";
    memberNameInput.removeAttribute("value");
    // console.log(memberName.innerHTML);
    linkPhoneInput.removeAttribute("value");
    detailAddressInput.removeAttribute("value");
}
closeImg.onclick = function(){
    editAddress.style.display = "none";
};
editImg.onclick = function () {
    flag = true;
    addTitle.innerHTML="编辑收货地址";
    editAddress.style.display = "block";
    memberNameInput.setAttribute("value" , memberName.innerHTML);
    // console.log(memberName.innerHTML);
    linkPhoneInput.setAttribute("value" , memberPhone.innerHTML);
    detailAddressInput.setAttribute("value" , memberAddress.innerHTML);
};
