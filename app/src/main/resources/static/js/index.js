document.addEventListener("DOMContentLoaded", function () {
  const clearButton = document.getElementById("clearbutton");
  const form = document.getElementById("flowerSearchForm");
  const selectName = document.getElementById("selectName"); // プルダウン
  const nameInput = document.getElementById("nameForm");    // テキスト入力
  if (!clearButton || !form || !selectName || !nameInput) return;
  // 初期状態の反映
  function toggleNameInput() {
      if (selectName.value) {
          nameInput.disabled = true;  // プルダウン選択中は入力不可
          nameInput.value = "";       // 入力内容クリア
      } else {
          nameInput.disabled = false; // プルダウン未選択なら入力可能
      }
  }
  toggleNameInput();
  // プルダウン変更時
  selectName.addEventListener("change", toggleNameInput);
  // クリアボタン押下時
  clearButton.addEventListener("click", function () {
      // 1. 全テキスト入力を空に
      form.querySelectorAll("input[type='text'], input[type='number']").forEach(el => el.value = "");
      // 2. 全プルダウンを placeholder に戻す
      form.querySelectorAll("select").forEach(select => {
          Array.from(select.options).forEach(option => option.selected = false);
          const placeholder = select.querySelector('option[value=""]');
          if (placeholder) placeholder.selected = true;
      });
      // 3. 名称テキスト入力を有効化
      nameInput.disabled = false;
  });
});


document.querySelectorAll('.flower-btn').forEach(btn => {
    const span = btn.querySelector('span');
    let fontSize = 14; // 初期サイズ
    span.style.fontSize = fontSize + 'px';

    const style = getComputedStyle(btn);
    const padding = parseFloat(style.paddingLeft) + parseFloat(style.paddingRight);
    const availableWidth = btn.clientWidth - padding;

    while (span.scrollWidth > availableWidth && fontSize > 10) { // 最小10px
        fontSize -= 1;
        span.style.fontSize = fontSize + 'px';
    }
});
  
  document.addEventListener("DOMContentLoaded", () => {
    const scrollBtn = document.getElementById("scrollTopBtn");
    if (!scrollBtn) return; // ボタンが存在しない場合は何もしない
    // ボタンクリックでトップへ
    scrollBtn.addEventListener("click", () => {
        window.scrollTo({
            top: 0,
            behavior: "smooth" // スムーズスクロール
        });
    });
});