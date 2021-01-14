package guru.framework.springmvcrest.controller;

import guru.framework.springmvcrest.model.users.Role;
import guru.framework.springmvcrest.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class RoleControllerTest {
    @InjectMocks
    RoleController roleController;

    @Mock
    RoleRepository roleRepository;

    @Test
    public void testFindAll() {
        // given
        Role role1=new Role("role2");
        Role role2=new Role("role1");

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        when(roleRepository.findAll()).thenReturn(roles);

        // when
        List<Role> result = roleController.getAllRoles();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getName())
                .isEqualTo(role1.getName());

        assertThat(result.get(1).getName())
                .isEqualTo(role2.getName());
    }
}