package de.scope.mdm.client.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseListDto<T> {

  private long total;
  private List<T> data;

  public ResponseListDto(List<T> dtos) {
    total = dtos.size();
    this.data = dtos;
  }
}
