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
    if (!scrollBtn) return; 
    // ボタンクリックでトップへ
    scrollBtn.addEventListener("click", () => {
        window.scrollTo({
            top: 0,
            behavior: "smooth" // スムーズスクロール
        });
    });
});


document.addEventListener("DOMContentLoaded", function () {
  const selectName = document.querySelector("[name='flowerNameId']");
  const nameInput = document.querySelector("[name='flowerName']");
  const selectColor = document.querySelector("[name='colorId']");
  const colorInput = document.querySelector("[name='colorName']");

  if (!selectName || !nameInput || !selectColor || !colorInput) return;

  // 共通の切り替え関数
  function toggleInput(selectEl, inputEl) {
    if (selectEl.value && selectEl.value !== "") {
      // 初期値以外が選択されている場合 → 入力不可
      inputEl.disabled = true;
      inputEl.value = "";
    } else {
      // 初期値（空）が選択されている場合 → 入力可能
      inputEl.disabled = false;
    }
  }

  // 初期状態の反映
  toggleInput(selectName, nameInput);
  toggleInput(selectColor, colorInput);

  // イベント登録
  selectName.addEventListener("change", () => toggleInput(selectName, nameInput));
  selectColor.addEventListener("change", () => toggleInput(selectColor, colorInput));
});