package de.scope.mdm.client.legalentity;

import de.scope.mdm.client.response.ResponseListDto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("legalEntity_tableView.fxml")
public class LegalEntityFxmlControllerImpl implements Initializable
{

    @FXML
    public TableColumn<LegalEntityDto, String> idColumn;
    @FXML
    public TableColumn<LegalEntityDto, String> nameColumn;
    @FXML
    public TableColumn<LegalEntityDto, String> categoryNameColumn;
    @FXML
    public TableColumn<LegalEntityDto, String> businessLineNameColumn;
    @FXML
    private TableView<LegalEntityDto> legalEntityTableView;

    private LegalEntityService legalEntityService;

    @Autowired
    public LegalEntityFxmlControllerImpl(LegalEntityService legalEntityService)
    {
        this.legalEntityService = legalEntityService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ResponseListDto<LegalEntityDto> legalEntities = getLegalEntities(0, 20, null, null, null);
        legalEntityTableView.getItems().setAll(legalEntities.getData());
    }

    @FXML
    public ResponseListDto<LegalEntityDto> getLegalEntities(Integer pageId, Integer size, Integer categoryId, String lei, String name)
    {
        ObservableList<LegalEntityDto> legalEntityTableViewItems = legalEntityTableView.getItems();
        ResponseListDto<LegalEntityDto> responseListDto = legalEntityService.getLegalEntitiesByCriterias(0, 20, categoryId, name);

        legalEntityTableViewItems.addAll(responseListDto.getData());

        return responseListDto;
    }
}
