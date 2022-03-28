/**
 * 
 */
 $(document).ready(function() {
			var hobbies = $("#hobbies").val().split(",");
			var $checkboxes = $("input[type=checkbox]");
			$checkboxes.each(function(element) {
				if (hobbies.indexOf(element.value) != -1) {
					element.setAttribute("checked", "checked");
				
				} else {
					element.removeAttribute("checked");
				}
			});
		});