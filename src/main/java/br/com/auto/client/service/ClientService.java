package br.com.auto.client.service;


import br.com.auto.client.error.exception.UnprocessableEntityException;
import br.com.auto.client.mapper.ClientMapper;
import br.com.auto.client.model.entity.ClientEntity;
import br.com.auto.client.model.request.ClientRequestDTO;
import br.com.auto.client.model.response.ClientResponseDTO;
import br.com.auto.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        ClientEntity client = clientMapper.toEntity(clientRequestDTO);
        ClientEntity savedClient = clientRepository.save(client);
        return clientMapper.toDto(savedClient);
    }

    public List<ClientResponseDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto)
                .toList();
    }

    public ClientResponseDTO getClientById(Long id) {
        return clientMapper.toDto(findById(id));
    }

    public void deleteClient(Long id) {
        findById(id);
        clientRepository.deleteById(id);
    }

    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        ClientEntity existingClient = findById(id);

        clientMapper.toDto(clientRequestDTO, existingClient);

        return clientMapper.toDto(clientRepository.save(existingClient));
    }

    private ClientEntity findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new UnprocessableEntityException("Client not found with id: " + id));
    }
}

