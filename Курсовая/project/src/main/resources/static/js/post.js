$(document).ready(function () {
//Кнопка "Изменить"
    $(this).on("click", "#edit", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "post_edit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                //Кнопка "Удалить" в "Изменить"
                $('.form').on("click", "#delete", function () {
                    console.log("delete");
                    if (confirm("Удалить запись?")) {
                        $.ajax({
                            url: "post_delete",
                            data: {
                                id: id
                            },
                            success: function () {
                                location.reload();
                            }
                        });
                    }
                });
            }
        })
    });
//Ссылка на добавление новой записи
    $(this).on("click", "a.href-a", function () {
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "post_add",
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                modal.find("#delete").hide();
                return false;
            }
        })
        return false;
    });
//add button

})