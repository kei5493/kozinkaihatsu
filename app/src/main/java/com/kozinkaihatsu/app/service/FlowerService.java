package com.kozinkaihatsu.app.service;
import java.util.List;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;

public interface FlowerService {

    /**
     * 検索結果リストを取得する（全件 or 条件付き）
     * @param form 検索条件フォーム
     * @return 検索結果DTOリスト
     */
    List<FlowersListDTO> flowersListDTO(FlowerSearchForm form);

    /**
     * 検索フォーム用データ（色一覧・名称一覧など）をキャッシュから取得する
     * @return 検索フォームDTO
     */
    FlowerSearchFormDTO getSearchFormDTO();

    /**
     * 入力フォームの内容を DTO に反映させる
     * @param form 入力フォーム
     * @param dto  キャッシュDTO
     * @return 更新済みDTO
     */
    FlowerSearchFormDTO giveSearchFormDTO(FlowerSearchForm form, FlowerSearchFormDTO dto);
}
