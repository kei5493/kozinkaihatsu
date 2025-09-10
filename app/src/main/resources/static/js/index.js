document.addEventListener("DOMContentLoaded", function () {
    // クリアボタンとフォームの取得
    const clearButton = document.getElementById("clearbutton");
    const form = document.getElementById("flowerSearchForm");
  
    if (!clearButton || !form) return;
  
    clearButton.addEventListener("click", function () {
      // -----------------------------
      // 1. テキスト入力を空に
      // -----------------------------
      form.querySelectorAll("input[type='text'], input[type='number']").forEach(el => {
        el.value = "";
      });
  
      // -----------------------------
      // 2. プルダウンを先頭の placeholder に戻す
      // placeholder option の value="" が選ばれる
      // -----------------------------
      form.querySelectorAll("select").forEach(select => {
        // 全 option の selected を解除
        Array.from(select.options).forEach(option => option.selected = false);
        // placeholder を selected にする
        const placeholder = select.querySelector('option[value=""]');
        if (placeholder) placeholder.selected = true;
      });
    });
  });
  