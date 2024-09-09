(() => {
  let url = "http://localhost:4040/api/kendaraan";
  let popup = document.querySelector("#confirmationPopup");
  let deleteButton = document.querySelectorAll(".btn-delete");
  let abortDeleteButton = document.querySelector("#abort-delete");
  let continueDeleteButton = document.querySelector("#continue-delete");
  let popupId = document.querySelector("#confirmationPopup .id-kendaraan");

  let id = "";
  for (let button of deleteButton) {
    button.addEventListener("click", () => {
      popup.classList.add("active");

      id = button.getAttribute("id");
      popupId.textContent = id;
    });
  }

  continueDeleteButton.addEventListener("click", () => {
    let deleteRequest = new XMLHttpRequest();
    deleteRequest.open("GET", `${url}/delete/${id}`);
    deleteRequest.send();
    deleteRequest.onload = () => {
      if (deleteRequest.status === 200) {
        window.location.reload("/kendaraan/index");
      }
    };
  });

  abortDeleteButton.addEventListener("click", () => {
    popup.classList.remove("active");
    popupId.innerHTML = "";
  });
})();
